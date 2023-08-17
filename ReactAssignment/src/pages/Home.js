import React,{useEffect} from "react";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import { loadUsers } from '../redux/actions';
import {useDispatch, useSelector} from 'react-redux';
import { useHistory  } from 'react-router-dom';

import Header from "../component/Header"

const Home = () => {
  let history = useHistory();
   
  document.body.style.backgroundColor = 'Beige'
    let dispatch = useDispatch();
   const {users} = useSelector(state => state.data)
    useEffect(
        () => {
        dispatch(loadUsers());
    }, []);

  return (
    
    <><Header /><Box p={7}>
      <TableContainer component={Paper}>
        <Table sx={{
          minWidth: 900, alignItems: 'left',
          justifyContent: 'left'
        }} aria-label="simple table">


          <TableBody>
            {users && users.map((user) => (
              <TableRow key={user.id} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                <TableCell>
                  <href
                        style={{width:"90px" }}
                        variant="contained"
                        
                        align="left"
                        onClick={()=>history.push(`/editUser/${user.id}`)}
                        ><h4>{user.tittle}</h4><h8>{user.category}</h8><br></br>{user.content}
                  </href>
                </TableCell>
              
              </TableRow>
            ))}
          </TableBody>
        </Table>

      </TableContainer>
    </Box></>
  )
}

export default Home;
