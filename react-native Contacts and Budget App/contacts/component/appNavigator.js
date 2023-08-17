import React from "react";
import { Text, View } from "react-native";
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import ShowContactList from "./showcontactlist";
import AddContact from "./addContact";
import editContact from "./updateContact";
const Stack = createNativeStackNavigator();
export function AppNavigator(){
    return(
        <NavigationContainer>
            <Stack.Navigator>
            <Stack.Screen name="ShowContactList" component={ShowContactList}/>
            <Stack.Screen name="AddContact" component={AddContact}/>
            <Stack.Screen name="editContact" component={editContact}/>
                
            </Stack.Navigator>
        </NavigationContainer>
    )
}