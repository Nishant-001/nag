import React,{useState} from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import AppBar from '@mui/material/AppBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from "@material-ui/icons/Menu";
import { useHistory } from 'react-router-dom';
import {useDispatch} from "react-redux"
import { addUser } from '../redux/actions';
const AddUser = () => {
  const [state,setState] = useState({
    tittle:"",
    category:"",
    content:"",
  });
  
  

  const [error,setError]  =useState("");

  let history = useHistory();

  let dispatch =useDispatch();

  
   const {tittle,category,content} =state;   
   const handleInputChange = (e) =>{
    let {name,value}= e.target;
    setState({...state,[name]:value});

    };  
    const handleSubmit =(e) =>{
      e.preventDefault();
      if(!tittle||!content||!category){
        setError("Please input all input Field");
      }else{
        dispatch(addUser(state));
        history.push("/");
        setError("");
      }
    }
  return (
      
    <div className='contained'>
        <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar variant="dense">
          <IconButton edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" color="inherit" component="div">
          <href
      style={{width:"90px" }}
      variant="contained"
      
      align="left"
      onClick={()=>history.push("/")}
      >Back</href>
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
        <br></br>
        {error && <h2>{error}</h2>}
        
        <br></br>
       
    
      <form 
      noValidate autoComplete='off' onSubmit={handleSubmit}>
      <div>
      <Box
      
      
      sx={{
        '& > :not(style)': { m: 1, width: '75ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <label style={{textAlign: "left"}}>Tittle</label>
      <TextField id="outlined-basic"  value={tittle} type ="text" name="tittle" variant="outlined"
      onChange={handleInputChange} />
      <label style={{textAlign: "left"}}>Categories</label>
      <TextField id="outlined-basic" value={category} type="text" name ="category" variant="outlined" onChange={handleInputChange} />
      <label style={{textAlign: "left"}}>Content</label>
      <textarea rows="3" id="outlined-basic" label= "Content" value={content} type="text" name ="content" variant="outlined" onChange={handleInputChange} />
      
      <span>
     
      <br></br>
      <Button
      
      variant="contained"
      
      align="left"
      type='submit'
      >submit</Button>
       &nbsp;
      <Button
      style={{width:"90px" }}
      variant="contained"
      color="warning"
      align="left"
      type='Reset'>Reset</Button>
      </span>
      
    </Box>
    </div>
    </form>
  
</div>
  )
}

export default AddUser
