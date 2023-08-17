import React, { useState } from 'react';
import { Text, View, TextInput, Button, Image, TouchableOpacity, StyleSheet } from 'react-native';
import { saveContact } from '../dao/database';
import ImageCropPicker from 'react-native-image-crop-picker';
import { useNavigation } from '@react-navigation/native';
import Icon from 'react-native-vector-icons/MaterialIcons';

export function AddContact() {
  const [name, setName] = useState('');
  const [mobile, setMobile] = useState('');
  const [landline, setLandline] = useState('');
  const [photo, setPhoto] = useState(null);
  const [favorite, setFavorite] = useState(false); 
  const navigation = useNavigation();

  const handleChoosePhoto = () => {
    ImageCropPicker.openPicker({
      cropping: true,
      cropperCircleOverlay: true,
      compressImageQuality: 0.7,
    })
      .then((image) => {
        setPhoto(image.path);
      })
      .catch((error) => {
        console.log('Image picker error:', error);
      });
  };

  const handleSubmit = () => {
    saveContact(name, mobile, landline, photo, favorite); 
    setName('');
    setMobile('');
    setLandline('');
    setPhoto(null);
    setFavorite(false);
    navigation.replace('ShowContactList'); 
  };

  const handleGoBack = () => {
    navigation.replace('ShowContactList'); 
  };

  return (
    <View style={styles.container}>
      <View style={styles.favoriteic}>
      <TouchableOpacity
        style={[styles.favoriteButton, favorite ? styles.favoriteButtonActive : null]}
        onPress={() => setFavorite(!favorite)}
      >
        <Icon name={favorite ? 'favorite' : 'favorite-border'} size={25} color={favorite ? 'red' : 'black'}/>
      </TouchableOpacity>
      </View>
      <View style={styles.favorite}>
      <TouchableOpacity style={styles.photoButton} onPress={handleChoosePhoto}>
      {photo ? <Image style={styles.photo} source={{ uri: photo }} /> : <Icon name='camera' size={70} style={styles.photoButtonText}/>}

      </TouchableOpacity>
      </View>
      <TextInput
        placeholder="Name"
        style={styles.inputtext}
        value={name}
        placeholderTextColor={'black'}
        onChangeText={setName}
      />
      <TextInput
        placeholder="Mobile phone number"
        value={mobile}
        style={styles.inputtext}
        placeholderTextColor={'black'}
        onChangeText={setMobile}
        keyboardType="phone-pad"
      />
      <TextInput
        placeholder="Landline number"
        value={landline}
        style={styles.inputtext}
        onChangeText={setLandline}
        placeholderTextColor={'black'}
        keyboardType="phone-pad"
      />
      <Button title="Save" onPress={handleSubmit} />
      <Button title="Back" onPress={handleGoBack} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 10,
    paddingRight: 10,
  },
  photoButton: {
    // backgroundColor: 'lightgray',
    padding: 10,
    marginBottom: 10,
    alignSelf: 'flex-start',
    borderRadius:350
  },
  photoButtonText: {
    textAlign: 'center',
    color: 'black',
    
  },
  inputtext: {
    color: 'black',
    marginBottom: 10,
  },
  photo: {
    width: 100,
    height: 100,
    marginBottom: 10,
    borderRadius:350
  },
  favorite:{
    marginLeft:150,
  },
  favoriteic:{
    marginLeft:350
  },
});

export default AddContact;
