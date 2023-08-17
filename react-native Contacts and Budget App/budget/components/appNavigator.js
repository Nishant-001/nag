import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';

import HomeView from './homeview';
import ListView from './listview';
import { NavigationContainer } from '@react-navigation/native';

const Stack = createStackNavigator();


const AppNavigator = () => {
  return (
    <NavigationContainer>
    <Stack.Navigator>
      <Stack.Screen name="BudgetEntry" component={HomeView} />
      <Stack.Screen name="BudgetEntryList" component={ListView} />
    </Stack.Navigator>
    </NavigationContainer>
  );
};

export default AppNavigator;

