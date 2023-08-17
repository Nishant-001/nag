import './App.css';
import {Switch, Route} from "react-router-dom";
import home from './pages/Home';
import  AddUser from './pages/AddUser'
import EditUser from './pages/EditUser';
function App() {
  return (
    <div className="App">
     <Switch>
       <Route exact path="/" component ={home}/>
       <Route  path="/addUser" component ={AddUser}/>
       <Route path ="/editUser/:id" component={EditUser}/>
       
     </Switch>
    </div>
  );
}

export default App;
