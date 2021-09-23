import "../Css/CustomerLogin.css";
import { changeData } from "../Store/CustomerLogin/action";
import { checkCredentials } from '../Functions/Login';
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from 'react-router-dom'
import { useState } from "react";
import BackHeader from '../Components/Headers/BackHeader';
import cusimg from "../Icons/cusimg.png"

function CustomerLogin() {

  const history = useHistory();
  const dispatch = useDispatch();
  const CustomerLogin = useSelector(x => x.CustomerLoginReducer)

  const [error, setError] = useState("");

  const handleInputChange = (e) => {
    dispatch(changeData(e))
  }

  const sendUser = (address) => {
    history.push("/" + address)
  }

  return (
    <div className="CustomerLogin">
      <BackHeader heading="Customer Login" />
      <div class="container" >
        <div class="row">
          <div class="col">
            <img className="Cusimg" src={cusimg}>
            </img>
          </div>
          
          <div className="formCustomerLogin">
          <div className="form-group form-id">
            <div class="row">
                <div className="col">
                  <div className="CustomerLoginKeyText">Customer Id</div>
                </div>
                <div className="col">
                  <input
                    type="text"
                    id="disabledTextInput"
                    className="form-control"
                    name="username"
                    placeholder="Enter Customer id"
                    value={CustomerLogin.customerId}
                    onChange={handleInputChange}
                    required
                  />
                </div>
              </div>
              <div className="row">
                <div className="col">
                  <div className="CustomerLoginKeyText">Password</div>
                </div>
                <div className="col">
                  <input
                    type="password"
                    id="disabledTextInput"
                    className="form-control"
                    name="password"
                    placeholder="Enter your password"
                    value={CustomerLogin.password}
                    onChange={handleInputChange}
                    required
                  />
                </div>
              </div>
            </div>

            <div className="errorCustomerLogin">{error}</div>

            <button className="buttonCustomerLogin" onClick={() => checkCredentials("I", setError, dispatch, CustomerLogin, history)}>Submit</button>
            <div className="notAnEmployee">
              <div className="Clickhere" onClick={() => sendUser("employeeLogin")}>Are you an Employee? Click here.</div>
            </div>
          </div>
        </div>
      </div>
      
    </div>
  );
}

export default CustomerLogin;
