import AsyncStorage from '@react-native-async-storage/async-storage';

export const storeFormData = async (data) => {
  try {
    const existingData = await AsyncStorage.getItem('formData');
    const formDataList = existingData ? JSON.parse(existingData) : [];
    formDataList.push(data);
    const jsonData = JSON.stringify(formDataList);
    await AsyncStorage.setItem('formData', jsonData);
    console.log('Form data stored successfully:', data);
  } catch (error) {
    console.log('Error storing form data:', error);
  }
};

export const fetchFormDataList = async () => {
  try {
    const jsonData = await AsyncStorage.getItem('formData');
    const formDataList = JSON.parse(jsonData) || [];
    console.log('Form data list retrieved successfully:', formDataList);
    return formDataList;
  } catch (error) {
    console.log('Error retrieving form data list:', error);
    return [];
  }
};
