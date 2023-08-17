import React,{useState,useEffect} from 'react'
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import AppBar from '@mui/material/AppBar';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from "@material-ui/icons/Menu";
import { useHistory, useParams } from 'react-router-dom';
import {useDispatch,useSelector} from "react-redux"
import { deleteUser, getSingleUser, updateUser } from '../redux/actions';
import ThumbUpOffAltIcon from '@mui/icons-material/ThumbUpOffAlt';
import FavoriteBorderOutlinedIcon from '@mui/icons-material/FavoriteBorderOutlined';

const EditUser = () => {
  const [state,setState] = useState({
    tittle:"",
    category:"",
    content:"",
  });
  
  const handleDelete= (id)=>{
  if(window.confirm("Are you sure Delete this Blog"))
     dispatch(deleteUser(id));
     history.push("/");
    
  }

  const [error,setError]  =useState("");

  let history = useHistory();

  let {id} =useParams();

  const {user}= useSelector(state => state.data);

  let dispatch =useDispatch();
useEffect(() =>{
dispatch(getSingleUser(id));
},[]);

useEffect(() =>{
if(user){
    setState({...user});
}
},[user])

  
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
        dispatch(updateUser(state,id));
        history.push("/");
        setError("");
      }
    }
    const [likes, setLikes] = useState(0);
    const [isClicked, setIsClicked] = useState(false);
  
    const LikeButton = () => {
      const [likes, setLikes] = useState(0);
      const [isClicked, setIsClicked] = useState(false);
       const handleClick = () => {
        if (isClicked) {
          setLikes(<FavoriteBorderOutlinedIcon/>);
        } else {
          setLikes(likes + 1);
        }
        setIsClicked(!isClicked);
      }
    
      }
      const handleClick = () => {
        if (isClicked) {
          setLikes(likes - 1);
        } else {
          setLikes(likes + 1);
        }
        setIsClicked(!isClicked);
      };
  return (
    
    <form 
      noValidate autoComplete='off' onSubmit={handleSubmit}>
    <div className='contained'>
        <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar variant="dense">
          <IconButton edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" color="inherit" component="div">
                  <href
                    style={{width:"50px" }}
                    variant="contained"
                    
                    align="left"
                    onClick={()=>history.push("/")}
                    >
                    Back &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </href>
                    <IconButton className={ `like-button ${isClicked && 'liked'}` } ><ThumbUpOffAltIcon onClick={ handleClick }/><span className="likes-counter">{ `Like | ${likes}` }</span> </IconButton>
                    
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <Button
                    
                    variant="contained"
                    color="success"
                    align="left"
                    type='submit'
                    onClick={()=> history.push()}
                    >Save</Button> 
                    <span>&nbsp;&nbsp;</span>
                    <Button variant="contained" class="btn btn-danger" 
                    onClick={()=>handleDelete(user.id)}
                    sx={{ height: 40 }}>
                      Delete
                    </Button>

          </Typography>
        </Toolbar>
        
      </AppBar>
      
    </Box>
   
    
        <br></br>
        {error && <h2>{error}</h2>}
        
        <br></br>
      <div>
      <Box sx={{'& > :not(style)': { m: 1, width: '75ch' },}}
          noValidate
          autoComplete="off"
      >
      
      <label style={{textAlign: "left"}}>Content</label>
      <textarea style={{background: "White"}} rows="15" id="outlined-basic" label= "Content" value={content} type="text" name ="content" variant="outlined" onChange={handleInputChange}  />
      
     
      
    </Box>
    </div>
    
  
</div>
</form>
  )
}

export default EditUser
