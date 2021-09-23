import '../Css/Transaction1.css';
import { useHistory } from "react-router-dom";
import { changeData } from "../Store/Transaction1/action";
import { useDispatch, useSelector } from "react-redux";
import SessionCheck from '../Auxillary/SessionCheck';
import BackHeader from '../Components/Headers/BackHeader';
import { getUrl } from '../Functions/Transaction';
import { useEffect } from 'react';

function Transaction1(props) {

  const dispatch = useDispatch();
  var transactionConstant = useSelector((x) => x.Transaction1Reducer);
  var error = props.error;
  var customerDetails = props.customerDetails;
  var banks = props.banks;
  var setError = props.setError;
  useEffect(()=>{
    var e = {
      target:{
        value:"",
        name:"recieverAccountName"
      }
    }
    dispatch(changeData(e))
    e.target.value="";
    e.target.name="recieverAccountNumber";
    dispatch(changeData(e));
  },[])

  const handleInputChange = (e) => {
    if(e.target.name === "institutionName") {
      e.target.code = banks[e.target.selectedIndex].bic;
    }
    dispatch(changeData(e));
  }

  const history = useHistory();
  const handleSubmit = () => {
    setError("");
    if(transactionConstant.recieverAccountName.trim().length==0){
      setError("Empty Account Name.");
      return;
    }
    if(isNaN(transactionConstant.recieverAccountNumber)|| transactionConstant.recieverAccountNumber==""){
      setError("Empty Account Number.");
      return;
    }
    if(transactionConstant.recieverAccountNumber<100000000000||transactionConstant.recieverAccountNumber>999999999999){
      setError("Account Number should be 12 digits.")
      return;
    }
    fetch(getUrl()+"/customer/checkBlacklist/"+transactionConstant.recieverAccountName).then(response=>response.json())
    .then(result=>{
      if(result.status==true){
        props.setValidatedFirstPage(true);
      }else{
        setError(result.description);
      }
    })
  }
  const bankOptions = banks.map((item, index) => {
    return <option value={item.bankname} key={item.bic}>{item.bankname}</option>
  });

  return (
    <SessionCheck>
    <div className="Transaction1">
      <BackHeader heading="Transaction-I"/>
      <div class="form" className="formMain" onSubmit={handleSubmit}>
        <div className="form-group">
        <div className="row">
        <div className="col">
          <div className="Transaction1Key">Sender Account Name:</div>
          </div>
          <div class="col" className="textcol">
          <input
            disabled
            type="text"
            id="disabledTextInput"
            className="form-control"
            value={customerDetails.accountholdername}
            onChange={handleInputChange}
          />
          </div>
          </div>
        </div>
        <div className="form-group">
        <div className="row">
        <div className="col">
        <div className="Transaction1Key">Balance Available(INR):</div>
        </div>
        <div class="col" className="textcol">
          <input
            disabled
            type="text"
            id="disabledTextInput"
            className="form-control"
            value={customerDetails.clearbalance}
            onChange={handleInputChange}
          />
          </div>
          </div>
        </div>
        <div className="form-group">
        <div className="row">
        <div className="col">
        <div className="Transaction1Key">Reciever Bank Name:</div>
        </div>
        <div class="col" className="textcol">
          <select className="form-control" name="institutionName"
            value={transactionConstant.institutionName}
            onChange={handleInputChange}>
            {bankOptions}
          </select>
          </div>
          </div>
        </div>
        <div className="form-group">
        <div className="row">
        <div className="col">
        <div className="Transaction1Key">Reciever Account Name:</div>
        </div>
        <div class="col" className="textcol">
          <input
            type="text"
            name="recieverAccountName"
            className="form-control"
            placeholder="Reciever Account Name"
            value={transactionConstant.recieverAccountName}
            onChange={handleInputChange}
          />
          </div>
          </div>
        </div>
        <div className="form-group">
        <div className="row">
        <div className="col">
        <div className="Transaction1Key">Reciever Account Number:</div>
        </div>
        <div class="col" className="textcol">
          <input
            type="number"
            pattern="[0-9]*"
            name="recieverAccountNumber"
            className="form-control"
            placeholder="Reciever Account Number"
            value={transactionConstant.recieverAccountNumber}
            maxLength="12"
            minLength="12"
            onChange={handleInputChange}
          />
          </div>
          </div>
        </div>
          <div className="form-group">
          <div className="row">
        <div className="col">
          <div className="Transaction1Key">BIC:</div>
          </div>
          <div class="col" className="textcol">
          <input
            disabled
            type="text"
            name="BIC"
            id="disabledTextInput"
            className="form-control"
            value={transactionConstant.BIC}
          />
          </div>
          </div>
        </div>
        {error==""?"":<div className="Transaction1Error">{error}</div>}
        <div className="button-row">
          <button className="buttonTransaction" onClick={()=>handleSubmit()}>
            Next
          </button>
        </div>
      </div>
    </div>
    </SessionCheck>
  );
}
export default Transaction1;