import {REDUCER_CONSTANTS} from '../Constants/Constants';

var initialState = {
    username: "",
    password: ""
}

export const CustomerLoginReducer = (state = initialState, action) =>{
    switch(action.type){
        //redux actions for every action
        case  REDUCER_CONSTANTS.CUSTOMER_ID: return {...state, username: action.data}
        case  REDUCER_CONSTANTS.PASSWORD: return {...state, password: action.data}
        default: return { ...state };
    }
}
