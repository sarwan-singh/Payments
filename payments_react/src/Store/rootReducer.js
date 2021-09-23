import {applyMiddleware, combineReducers} from 'redux';
import {Transaction2Reducer} from './Transaction2/reducer'
import {CustomerLoginReducer} from './CustomerLogin/reducer'
import {Transaction1Reducer} from './Transaction1/reducer'
import {EmployeeLoginReducer} from './EmployeeLogin/reducer'
import {UserDetailsReducer} from './UserDetails/reducer'
import thunk from 'redux-thunk';

const rootReducer= combineReducers({Transaction1Reducer, Transaction2Reducer, CustomerLoginReducer, EmployeeLoginReducer, UserDetailsReducer}, applyMiddleware(thunk));
export default rootReducer;