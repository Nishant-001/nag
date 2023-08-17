import React, { useState } from 'react';
import { View, Text, TextInput, StyleSheet, Button, Alert } from 'react-native';
import { storeFormData, fetchFormDataList} from '../asyncStorageUtil/asyncStorageutil';
import { useNavigation } from '@react-navigation/native';


const HomeView = () => {
  const [name, setName] = useState('');
  const [plannedAmount, setPlannedAmount] = useState('');
  const [actualAmount, setActualAmount] = useState('');

  const handleNameChange = (text) => {
    setName(text);
  };

  const handlePlannedAmountChange = (text) => {
    setPlannedAmount(text);
  };

  const handleActualAmountChange = (text) => {
    setActualAmount(text);
  };
  const navigation = useNavigation() ;

  const handleViewList = () => {
    navigation.navigate('BudgetEntryList');
  };
    
  const handleSubmit = async () => {
      const data = {
        name: name,
        plannedAmount: plannedAmount,
        actualAmount: actualAmount,
      };

      storeFormData(data);
      Alert.alert("Data Saved");
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        placeholder="Name"
        placeholderTextColor={'black'}
        value={name}
        onChangeText={handleNameChange}
      />
      <TextInput
        style={styles.input}
        placeholder="Planned Amount"
        placeholderTextColor={'black'}
        value={plannedAmount}
        onChangeText={handlePlannedAmountChange}
        keyboardType="numeric"
      />
      <TextInput
        style={styles.input}
        placeholder="Actual Amount"
        placeholderTextColor={'black'}
        value={actualAmount}
        onChangeText={handleActualAmountChange}
        keyboardType="numeric"
      />
      <Button title="Submit" onPress={handleSubmit} />
      <Button title="List" onPress={handleViewList} />

    </View>

    
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    paddingHorizontal: 16,
  },
  input: {
    color:'black',
    borderWidth: 1,
    borderColor: 'black',
    marginBottom: 10,
    paddingVertical: 8,
    paddingHorizontal: 12,
    fontSize: 16,
  },
});

  export default HomeView;
  
  