import { Switch, Route } from 'react-router-dom'
import { Provider} from 'react-redux'
import { createStore, applyMiddleware } from 'redux'
import thunk  from "redux-thunk"
import rootReducer from "./Store/rootReducer";
import CustomerHome from './Screens/CustomerHome';
import CustomerLogin from './Screens/CustomerLogin';
import CustomerProfile from './Screens/CustomerProfile';
import CustomerTransactions from './Screens/CustomerTransactions';
import EmployeeLogin from './Screens/EmployeeLogin';
import Home from './Screens/Home';
import Transaction1 from './Screens/Transaction1';
import Transaction2 from './Screens/Transaction2';
import Transaction from './Screens/Transaction';
const store = createStore(rootReducer,applyMiddleware(thunk))
const App = () => {

  return (
    <Provider store={store}>
      <div>
        <Switch>
          <Route path="/customerhome" component={CustomerHome}></Route>
          <Route path="/customerlogin" component={CustomerLogin}></Route>
          <Route path="/customerprofile" component={CustomerProfile}></Route>
          <Route path="/customertransactions" component={CustomerTransactions}></Route>
          <Route path="/employeelogin" component={EmployeeLogin}></Route>
          <Route path="/home" component={Home}></Route>
          {/* <Route path="/transaction1" component={Transaction1}></Route> */}
          {/* <Route path="/transaction2" component={Transaction2}></Route> */}
          <Route path="/transaction" component={Transaction}></Route>
          <Route path="" component={Home} ></Route>
        </Switch>
      </div>
    </Provider>

  );
}

export default App;