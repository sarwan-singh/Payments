import { useEffect } from "react";
import { getUrl } from '../Functions/Transaction'
import { useHistory } from 'react-router-dom';

function SessionCheck(props){
    const history = useHistory();

    useEffect(()=>{
        var jwtStored = localStorage.getItem("jwt")
        var options = {
            method : 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ 
              status:true,
              jwt: jwtStored
            })
        }
        fetch(getUrl()+"/sessioncheck", options).then(response=>response.json())
        .then(result=>{
            if(result.status){

            }else{
                history.replace("/home");
            }
        })
    },[])

    return props.children
}

export default SessionCheck;