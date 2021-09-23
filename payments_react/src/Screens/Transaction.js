import { useEffect, useState } from "react";
import { fetchDetails, getUrl, makeTransaction } from "../Functions/Transaction";
import Transaction1 from "./Transaction1";
import Transaction2 from "./Transaction2";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router-dom";

function Transaction(){
    var history = useHistory();
    const dispatch = useDispatch();
    var transactionConstant1 = useSelector((x) => x.Transaction1Reducer);
    var transactionConstant2 = useSelector((x) => x.Transaction2Reducer);
    const [ validatedFirstPage, setValidatedFirstPage ] = useState(false);
    var [customerDetails, setCustomerDetails] = useState({});
    var [error, setError] = useState("");
    var [banks, setBanks] = useState([]);
    const [messages, setMessage] = useState([]);
    const [currencies, setCurrencies] = useState([]);
    const [transcationsuccess, setTransactionsuccess]=useState(false);
    useEffect(()=>{
        fetchDetails(setCustomerDetails, setCurrencies, setMessage, dispatch, setBanks);
    }, []);

    const TransactPayment = async ()=>{
        if(transcationsuccess){
            return;
        }
        setError("");
        if(transactionConstant2.amount==0){
            setError("Amount should be greater than 0.");
        }else{
            setTransactionsuccess(false);
            var transactionResponse = await makeTransaction(
                                        transactionConstant1.recieverAccountName.trim(),
                                        transactionConstant1.recieverAccountNumber,
                                        transactionConstant1.BIC, 
                                        transactionConstant2.messageCode, 
                                        transactionConstant2.currency, 
                                        transactionConstant2.amount);
            if(transactionResponse.status==false){
                setError(transactionResponse.description);
            }else{
                setTransactionsuccess(true);
            }
        }
    }
    
    return(
        <div>
            {validatedFirstPage?
            <Transaction2  
                setValidatedFirstPage={setValidatedFirstPage}
                messages={messages}
                setMessage={setMessage}
                currencies={currencies}
                setCurrencies={setCurrencies}
                customerDetails={customerDetails}
                setCustomerDetails={setCustomerDetails}
                error={error}
                setError={setError}
                TransactionConstant={transactionConstant1}
                TransactPayment={TransactPayment}
                transcationsuccess={transcationsuccess}
                setTransactionsuccess={setTransactionsuccess}/>
                :
            <Transaction1
                setValidatedFirstPage={setValidatedFirstPage}
                customerDetails={customerDetails}
                setCustomerDetails={setCustomerDetails}
                error={error}
                setError={setError}
                banks={banks}
                setBanks={setBanks}
                TransactionConstant={transactionConstant2}/>}
        </div>
    )

}

export default Transaction;