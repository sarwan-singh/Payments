import { Link, useHistory } from 'react-router-dom';
import SessionCheck from '../Auxillary/SessionCheck';
import '../Css/CustomerHome.css';
import CustomerProfile from './CustomerProfile';
import CustomerTransactions from './CustomerTransactions';
import Transaction1 from './Transaction1';
import LogoutHeader from '../Components/Headers/LogoutHeader'

function CustomerHome() {
  var history = useHistory();

  const sendUser= (value)=>{
    history.push("/"+value);
  }

  return (
    <SessionCheck>
      <div id="image">
    <div className="CustomerHome">
      <LogoutHeader heading="Dashboard"/>
      <div className="CustomerHomeRow" >
        <div className="CustomerHomeCard" onClick={()=>sendUser("customerProfile")}> Profile </div>
        <div className="CustomerHomeCard"onClick={()=>sendUser("customerTransactions")}> Transactions </div>
        <div className="CustomerHomeCard" onClick={()=>sendUser("transaction")}> Make Transaction </div>
      </div>
    </div>
    </div>
    </SessionCheck>
  );
}

export default CustomerHome;
