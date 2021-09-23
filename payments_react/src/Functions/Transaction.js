import { changeData as changeData1} from "../Store/Transaction1/action";
import { changeData as changeData2 } from "../Store/Transaction2/action";
const url = "http://localhost:8081";

const transferTypes = [
  "Customer Transfer",
  "Bank Transfer for Own Account"
]

export const getUrl=()=>{
  return url;
}

export const getTransferType=(type)=>{
  if(type==="customer"){
    return transferTypes[0];
  }else{
    return transferTypes[1];
  }
}

export const fetchDetails = (setCustomerDetails, setCurrencies, setMessage, dispatch, setBanks)=>{
  fetch(url+"/message")
    .then(response=>response.json())
    .then(finalResponse=>{
      setMessage(finalResponse.data);
      var e ={
        target:{
          name:"messageCode",
          value:finalResponse.data[0].messagecode
        }
      }
      dispatch(changeData2(e));
    });
    fetch(url+"/currency")
    .then(response=>response.json())
    .then(finalResponse=>{
      setCurrencies(finalResponse.data);
      var e ={
        target:{
          name:"currency",
          value:finalResponse.data[0].currencycode
        }
      }
      dispatch(changeData2(e));
    });
    var jwtStored = localStorage.getItem("jwt")
      var options = {
          method : 'GET',
          headers: { 'Content-Type': 'application/json', 'Authorization': "Bearer "+jwtStored }
      }
      fetch(url+"/customer/user", options).then(response=>response.json())
      .then(result=>{
        setCustomerDetails(result.data);
      })

      fetch(url+"/customer/user", options).then(response=>response.json())
      .then(result=>{
        setCustomerDetails(result.data);
        })
      fetch(url+"/bank").then(response=>response.json()).then(result=>{
        setBanks(result.data)
        const e = {
          target:{
            name: "institutionName",
            code: result.data[0].bic
          }
        }
        dispatch(changeData1(e))
      });
}

export const makeTransaction= async (name, number, bic, message, currency, amount)=>{

  var transactionData = {
    recieverName :name,
    recieverAccountNumber : number,
    amount : amount,
    currency : currency,
    message : message,
    bankCode : bic
  }
  var jwtStored = localStorage.getItem("jwt")
  var options = {
      method : 'POST',
      headers: { 'Content-Type': 'application/json', 'Authorization': "Bearer "+jwtStored },
      body: JSON.stringify(transactionData)
  }
  var finalData;
  var tempWait = await fetch(getUrl()+"/transaction/user", options)
    .then(response=>response.json())
    .then(result=>{
      finalData = result;
    })
    return finalData;
}