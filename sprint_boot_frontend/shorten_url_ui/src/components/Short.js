import React, {useEffect, useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import Button from '@mui/material/Button';
import { Paper } from '@mui/material';


export default function Short() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const [mainURL, setMainURL]=useState('')
    const [shortURL, setShortURL]=useState('')
    const [shorts, setShorts]=useState([])
    const [lastShort, setLastShort]=useState([])
    const [code, setCode] = useState([])

    const handleClick=(e)=>{
        e.preventDefault()
        const short={shortURL, mainURL}
        console.log(short)
        fetch("http://localhost:8080/short", {
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(short)
        }).then((response)=>{
            setCode(response.status)
            console.log(response)
            console.log("Submit Clicked")
            setCode(response.status)
            console.log(code)
            response.json().then(obj=>{
                setLastShort(obj)
            })
        })

        // window.location.reload();
        // setTimeout(
        // fetch("http://localhost:8080/get/last")
        // .then(res=>res.json())
        // .then((result)=>{
        //     setLastShort(result)
        // })
        // , 500)

    }
    useEffect(()=>{
        fetch("http://localhost:8080/get/all")
        .then(res=>res.json())
        .then((result)=>{
            setShorts(result)
        }
        )
    },[])
  return (
    <Container>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="standard-basic" label="Main URL" variant="standard" 
      value={mainURL}
      onChange={(e)=>setMainURL(e.target.value)}
      />
      <TextField id="standard-basic" label="Short URL" variant="standard" 
      value={shortURL}
      onChange={(e)=>setShortURL(e.target.value)}
      />
    </Box>
    
    {/* http://localhost:8080/
    {shortURL} */}
    <div><Button variant="outlined" onClick={handleClick}>Submit</Button></div>
    <div>
            {code == '200'? <div>http://localhost:8080/{lastShort.shortURL}</div>: null }
    </div>
    <h1>Shorten so far...</h1>
    <Paper elevation={3} style={paperStyle}>

        {shorts.map(short=>(
            <Paper elevation={6} style={{margin:'10px', padding:"15px", textAlign:"left"}} key={short.shortURL}>
                Main URl: {short.mainURL}<br/>
                Shorten URL: http://localhost:8080/{short.shortURL}<br/>
            </Paper>
        ))}

    </Paper>
    </Container>
    
  );
}
