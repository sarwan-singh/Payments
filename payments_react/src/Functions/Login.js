import { getUrl } from './Transaction';
import { updateUserDetails } from '../Store/UserDetails/action';

export const checkCredentials = (custType, setError, dispatch, userLogin, history)=>{
    
  
  var options = {
      method : 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ 
        username:userLogin.username,
        password:userLogin.password
      })
    }

    fetch(getUrl()+"/auth", options)
    .then(response=>response.json() ).then(result=>{
      if(result.status==false){
        setError("Wrong Credentials.");
      }else{
        var options = {
          method : 'GET',
          headers : {'Authorization': "Bearer "+result.jwt, 'Content-Type': 'application/json'}
        }
        fetch(getUrl()+"/customer/user",options)
        .then(async response2=>await response2.json()).then(result2=>{
          if(result2.data.customertype!=custType){
            setError("Wrong Credentials.");
          }else{
            localStorage.setItem("jwt", result.jwt);

            var start = JSON.stringify(result2.data);

            if(custType=="B"){
              window.location.href="/transaction";
            }else{
              window.location.href="/customerHome";
            }
          }
        })
      }
    })
  }