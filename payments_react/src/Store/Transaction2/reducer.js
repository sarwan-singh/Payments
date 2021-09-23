import {REDUCER_CONSTANTS} from '../Constants/Constants';
// import axios from 'axios';
// import thunk from 'redux-thunk';

var initialState = {
    transferType: "",
    messageCode: "",
    amount: 0,
    addTransferFee: 0,
    clearBalance: 0,
    currency: ""
}

export const Transaction2Reducer = (state = initialState, action) =>{
    switch(action.type){
        //redux actions for every action
        case  REDUCER_CONSTANTS.TRANSFER_TYPE: return {...state, transferType: action.data}
        case  REDUCER_CONSTANTS.MESSAGE_CODE: return {...state, messageCode: action.data}
        case  REDUCER_CONSTANTS.AMOUNT: return {...state, amount: (action.data==""||isNaN(action.data))?"0":parseInt(action.data), addTransferFee: (action.data==""||isNaN(action.data))?"0":(parseInt(action.data)+(parseInt(action.data)*0.025))}
        case  REDUCER_CONSTANTS.CLEAR_BALANCE: return {...state, clearBalance: parseInt(action.data)}
        case  REDUCER_CONSTANTS.CURRENCY: return {...state, currency: action.data}
        default: return { ...state };
    }
}
