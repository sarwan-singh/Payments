import TransactionModel from '../Components/Models/TransactionModel';
import '../Css/CustomerTransactions.css';
import SessionCheck from '../Auxillary/SessionCheck';
import { useEffect, useState } from 'react';
import { getUrl } from '../Functions/Transaction';
import { useHistory } from 'react-router-dom';
import BackHeader from '../Components/Headers/BackHeader'

function CustomerTransactions(props) {

  var [transactions, setTransactions] = useState([]);
  var history = useHistory();
  useEffect(()=>{
    var jwtStored = localStorage.getItem("jwt")
        var options = {
            method : 'GET',
            headers: { 'Content-Type': 'application/json', 'Authorization': "Bearer "+jwtStored }
        }
        fetch(getUrl()+"/transaction/user", options).then(response=>response.json())
        .then(result=>{
          setTransactions(result.data.reverse());
          console.log(result.data)
        })
  }, [])

  const displayTransactions = transactions.map((item, index)=>{
    return <TransactionModel data={item}/>
  })

  const displayNoTransactions = () =>{
    return(
      <div className="CustomerTransactionsNoTransactions">No Transactions :(</div>
    )
  }

  return (
    <SessionCheck>
      <div className={transactions.length>0?"CustomerTransactions":"CustomerTransactions CustomerTransactionsFull"}>
          
        <BackHeader heading="Transactions"/>
          {transactions.length>0?displayTransactions:displayNoTransactions()}
      </div>
    </SessionCheck>
  );
}

export default CustomerTransactions;
