

//mapping values with respect to name as type in action
export const changeData= (e)=>{


    return {
        type : e.target.name,
        data : e.target.value
    }
}
