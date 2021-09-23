import { useSelector, useDispatch } from 'react-redux';
import '../Css/EmployeeLogin.css';
import { useHistory } from 'react-router-dom';
import { checkCredentials } from '../Functions/Login';
import { changeData } from '../Store/EmployeeLogin/action';
import { useState } from 'react';
import BackHeader from '../Components/Headers/BackHeader';
import empimg from "../Icons/empimg.png"
function EmployeeLogin() {

  const history=useHistory();
  const dispatch=useDispatch();
  const EmployeeLoginReducer=useSelector(x=>x.EmployeeLoginReducer)
  
  const [error, setError] = useState("");
  
  const handleInputChange=(e)=>{
    dispatch(changeData(e));
  }
  const sendUser=(address)=>
  {
    history.push("/"+address)
  }

  return (
    <div className="EmployeeLogin">
      <BackHeader heading="Employee Login"/>
      <div class="container" >
        <div class="row">
      <div className="formEmployeeLogin">
          <div className="form-group form-id">
          <div class="row">
          <div className="col">
          <div className="EmployeeLoginKeyText">Employee Id</div>
            </div>
            <div className="col">
            <input
             type="text"
             name="username"
             className="form-control"
             placeholder="Enter Employee Id"
             id="employeeid"
             value={EmployeeLogin.employeeId}
             onChange={handleInputChange}
             required
            />
          </div>
        </div>
        <div className="row">
        <div className="col">
          <div className="EmployeeLoginKeyText">Password</div>
            </div>
            <div className="col">
            <input
              type="password"
              id="password"
              className="form-control"
              name="password"
              placeholder="Enter your password"
              value={EmployeeLogin.password}
              onChange={handleInputChange}
              required
            />
          </div>
        </div>
</div>
        <div className="errorCustomerLogin">{error}</div>

        <button className="buttonEmployeeLogin" onClick={()=>checkCredentials("B", setError, dispatch, EmployeeLoginReducer, history)}>Submit</button>
        <div className="notAnCustomer">
        <div className="Clickhere" onClick={()=>sendUser("CustomerLogin")}>Are you a Customer? Click here.</div>
        </div>
      </div>
          <div class="col">
            <img className="Empimg" src={empimg}>
            </img>
          </div>
          </div>
          </div>
    </div>
  );
}

export default EmployeeLogin;
