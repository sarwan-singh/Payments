import {REDUCER_CONSTANTS} from '../Constants/Constants';
// import axios from 'axios';
// import thunk from 'redux-thunk';

var initialState = {
    senderAccountName: "",
    balanceAvailable: "",
    institutionName: "",
    recieverAccountName: "",
    recieverAccountNumber: "",
    BIC: ""
}

export const Transaction1Reducer = (state = initialState, action) =>{
    switch(action.type){
        //redux actions for every action
        case  REDUCER_CONSTANTS.SENDER_ACCOUNT_NAME: return {...state, senderAccountName: action.data}
        case  REDUCER_CONSTANTS.BALANCE_AVAILABLE: return {...state, balanceAvailable: parseInt(action.data)}
        case  REDUCER_CONSTANTS.RECIEVER_ACCOUNT_NUMBER: return {...state, recieverAccountNumber: parseInt(action.data)}
        case  REDUCER_CONSTANTS.INSTITUTION_NAME: return {...state, institutionName: action.data, BIC: action.code}
        case  REDUCER_CONSTANTS.RECIEVER_ACCOUNT_NAME: return {...state, recieverAccountName: action.data}
        default: return { ...state };
    }
}