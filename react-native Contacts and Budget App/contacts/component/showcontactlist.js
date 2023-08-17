import React, { useEffect, useState } from 'react';
import {View,Text,StyleSheet,TouchableOpacity,Image,TextInput,Alert,SafeAreaView,} from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';
import Swipelist from 'react-native-swipeable-list-view';
import { useNavigation } from '@react-navigation/native';
import { getAllContacts, searchContacts, deleteContact, getfavContacts } from '../dao/database';

const ShowContactList = () => {
  const [contacts, setContacts] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [favorite, setFavorite] = useState(false);
  const navigation = useNavigation();
  const [openRowKey, setOpenRowKey] = useState(null);

  useEffect(() => {
    loadContacts();
  }, []);

  const loadContacts = () => {
    if (favorite) {
      getfavContacts((data) => {
        setContacts(data);
      });
    } else {
      getAllContacts((data) => {
        setContacts(data);
      });
    }
  };

  const handleEditContact = (item) => {
    navigation.navigate('editContact', { contact: item });
  };

  const handleDeleteContact = (item) => {
    Alert.alert('Delete?', item.name, [
      {
        text: 'Cancel',
        style: 'cancel',
      },
      {
        text: 'Delete',
        style: 'destructive',
        onPress: () => {
          deleteContact(item.id, () => {
            navigation.replace('ShowContactList');
          });
        },
      },
    ]);
  };

  const handleNavigateToAddContact = () => {
    navigation.navigate('AddContact');
  };

  const handleSearch = (text) => {
    setSearchQuery(text);
    searchContacts(text, (data) => {
      setContacts(data);
      useEffect();
    });
  };

  const handleFavoritePress = () => {
    setFavorite(!favorite);
    loadContacts();
  };

  const handleRowOpen = (key) => {
    setOpenRowKey(key);
  };

  const handleRowClose = () => {
    setOpenRowKey(null);
  };

  return (
    <SafeAreaView style={styles.container}>
      <TouchableOpacity
        style={[styles.favoriteButton, favorite ? styles.favoriteButtonActive : null]}
        onPress={handleFavoritePress}
      >
        <Icon name={!favorite ? 'favorite' : 'favorite-border'} size={25} color={favorite ?  'black':'red'} />
      </TouchableOpacity>
      <View style={styles.searchBar}>
        <TextInput
          style={styles.searchInput}
          placeholder="Search by name"
          placeholderTextColor={'black'}
          value={searchQuery}
          onChangeText={handleSearch}
        />
      </View>

      <Swipelist
        data={contacts}
        renderRightItem={(item) => (
          <View style={styles.contactItem}>
            <Image source={{ uri: item.photo }} style={styles.contactImage} />
            <Text style={styles.text}>{item.name}</Text>
          </View>
        )}
        renderHiddenItem={(item) => (
          <View style={styles.hiddenItem}>
            <TouchableOpacity
              style={[styles.rightAction, { backgroundColor: 'white' }]}
              onPress={() => {
                handleEditContact(item);
              }}
            >
              <Icon name="edit" size={25} color={'blue'} />
            </TouchableOpacity>
            <TouchableOpacity
              style={[styles.rightAction, { backgroundColor: 'white' }]}
              onPress={() => {
                handleDeleteContact(item);
              }}
            >
              <Icon name="delete" size={25} color={'red'} />
            </TouchableOpacity>
          </View>
        )}
        rightOpenValue={150}
        disableRightSwipe={true}
        closeOnScroll={true}
        onRowOpen={handleRowOpen}
        onRowClose={handleRowClose}
        closeOnRowPress={true}
        shouldToggleOnRowPress={false}
        shouldItemUpdate={(currentItemKey, newItemKey) => currentItemKey !== openRowKey || newItemKey !== openRowKey}
      />

      <TouchableOpacity
        style={styles.addButton}
        onPress={handleNavigateToAddContact}
      >
        <Icon name="add" size={35} color={'white'} />
      </TouchableOpacity>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  rightItemContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginLeft: 20,
  },
  searchBar: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 10,
  },
  searchInput: {
    flex: 1,
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    marginRight: 10,
    paddingHorizontal: 10,
  },
  text: {
    color: 'black',
  },
  addButton: {
    backgroundColor: '#2D7A9A',
    width: 50,
    height: 50,
    borderRadius: 25,
    marginLeft: 320,
    alignItems: 'center',
    justifyContent: 'center',
  },
  contactItem: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 20,
  },
  contactImage: {
    width: 50,
    height: 50,
    borderRadius: 25,
    marginRight: 10,
  },
  contactName: {
    flex: 1,
    fontSize: 18,
    fontWeight: 'bold',
    color: 'black',
  },
  hiddenItem: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'flex-end',
  },
  rightAction: {
    width: 75,
    height: '100%',
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#bfbfbf',
  },
  favoriteButton: {
    marginLeft: 320,
    marginBottom: 10,
  },
  favoriteButtonActive: {
    color: 'red',
  },
});

export default ShowContactList;
