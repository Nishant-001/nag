import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet,ScrollView  } from 'react-native';
import { fetchFormDataList } from '../asyncStorageUtil/asyncStorageutil';


const ListView = () => {
  const [formDataList, setFormDataList] = useState([]);

  useEffect(() => {
    fetFormDataList();
  }, []);

  const fetFormDataList = async () => {
    const list = await fetchFormDataList();
    setFormDataList(list);
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Form Data List</Text>
      <ScrollView>
        {formDataList.map((formData, index) => (
          <View key={index} style={styles.formDataItem}>
            <Text style={styles.textbox}>Name: {formData.name}</Text>
            <Text style={styles.textbox}>Planned Amount: {formData.plannedAmount}</Text>
            <Text style={styles.textbox}>Actual Amount: {formData.actualAmount}</Text>
          </View>
        ))}
      </ScrollView>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
  },
  title: {
    color:'black',
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  formDataItem: {
    padding:20,
    borderWidth:2,
    borderColor:'black',
    backgroundColor:'beige',
    borderRadius:100,
    marginBottom: 30,
    color:'black'
  },
  textbox:{
    color:'black'
  }
});

export default ListView;
