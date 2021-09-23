import {REDUCER_CONSTANTS} from '../Constants/Constants';

var initialState = {
    userDetails : {}
}

export const UserDetailsReducer = (state = initialState, action) =>{
    switch(action.type){
        //redux actions for every action
        case  REDUCER_CONSTANTS.INSERT_USER: return {...state, userDetails: action.data}
        default: return { ...state };
    }
}
