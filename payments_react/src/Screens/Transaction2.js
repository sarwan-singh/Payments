import "../Css/Transaction2.css";
import { changeData } from "../Store/Transaction2/action";
import { useDispatch, useSelector } from "react-redux";
import SessionCheck from "../Auxillary/SessionCheck";
import TransactiontwoHeader from '../Components/Headers/TransactiontwoHeader';
import homebank from "../Icons/homebank.JPG"
import { ajaxPrefilter } from "jquery";

function Transaction2(props) {
  const dispatch = useDispatch();
  var Transaction = useSelector((x) => x.Transaction2Reducer);
  var error = props.error;
  var customerDetails = props.customerDetails;
  var setError = props.setError;
  var messages = props.messages;
  var currencies = props.currencies;

  //updating redux state
  const handleInputChange = (e) => {
    dispatch(changeData(e));
  };



  //displaying messageCodes and currencies in drop down
  const displayMessageCodes = messages.map((item, index) => {
    return (
      <option className="dropdown-item" key={index}>
        {item.messagecode}
      </option>
    );
  });

  const displayCurrencies = currencies.map((item, index) => {
    return (
      <option className="dropdown-item" key={index}>
        {item.currencycode}
      </option>
    );
  });

  return (
    <SessionCheck>
      <div className="Transaction2">
        <TransactiontwoHeader setValidatedFirstPage={props.setValidatedFirstPage} heading="Transaction-II" />
        <div class="form" className="formMain">
          <div className="form-group">
            <div className="row">
              <div className="col">
                <div className="Transaction2Key">Transfer Type</div>
              </div>
              <div class="col" className="textcol">
                <input
                  type="text"
                  id="disabledTextInput"
                  className="form-control"
                  name="transferType"
                  placeholder="Transfer-Type"
                  value={customerDetails.customertype == "I" ? "Customer Transfer" : "Bank Transfer for Own Account"}
                  disabled
                  onChange={handleInputChange}
                />
              </div>
            </div>
          </div>
          <div className="form-group">
            <div className="row">
              <div className="col">
                <div className="Transaction2Key">Message Code</div>
              </div>
              <div class="col" className="textcol">
                <select
                  className="form-control"
                  name="messageCode"
                  onChange={handleInputChange}
                >
                  {displayMessageCodes}
                </select>
              </div>
            </div>
          </div>
          <div className="form-group">
            <div className="row">
              <div className="col">
                <div className="Transaction2Key">Currency</div>
              </div>
              <div class="col" className="textcol">
                <select
                  className="form-control"
                  name="currency"
                  onChange={handleInputChange}
                >
                  {displayCurrencies}
                </select>
              </div>
            </div>
          </div>
          <div className="form-group">
            <div className="row">
              <div className="col">
                <div className="Transaction2Key">Amount</div>
              </div>
              <div class="col" className="textcol">
                <input
                  className="form-control"
                  type="number"
                  name="amount"
                  value="0"
                  placeholder="Enter amount"
                  value={Transaction.amount}
                  onChange={handleInputChange}
                />
              </div>
            </div>
          </div>
          <div className="form-group">
            <div className="row">
              <div className="col">
                <div className="Transaction2Key">Amount with Transfer Fee</div>
                <div className="Transaction2Key">(+0.25% of amount)</div>
              </div>
              <div class="col" className="textcol">
                <input
                  type="text"
                  id="disabledTextInput"
                  className="form-control"
                  name="addTransferFee"
                  value={Transaction.addTransferFee}
                  placeholder="0"
                  disabled
                  onChange={handleInputChange}
                />
              </div>
            </div>
          </div>
          <div className="form-group">
            <div className="row">
              <div className="col">
                <div className="Transaction2Key">Clear Balance(INR)</div>
              </div>
              <div class="col" className="textcol">
                <input
                  type="text"
                  id="disabledTextInput"
                  className="form-control"
                  name="clearBalance"
                  value={customerDetails.clearbalance}
                  placeholder="Clear Balance"
                  disabled
                  onChange={handleInputChange}
                />
              </div>
            </div>
          </div>
          {error == "" ? "" : <div className="Transaction2Error">{error}</div>}
          <div className="button-row">
            {props.transcationsuccess == true ?(
             alert("transaction successfull....!"),
            //  window.location.href
             window.location.href="/customerTransactions"
            )
              :""}
            <button type="submit"  data-toggle="modal" data-target="#exampleModalCenter"className="buttonTransaction" onClick={() => { props.TransactPayment(); }}>
              Transfer
            </button>


          </div>
        </div>
      </div>
    </SessionCheck>
  );
}

export default Transaction2;
