import { useHistory } from 'react-router-dom';
import back from '../../Icons/back.png';
import '../HeadersCSS/BackHeader.css'

function BackHeader(props){
    var history = useHistory();
    return(
        <div className="BackHeader">
          <img src={back} className="back" onClick={()=>history.goBack()}/>
          <div className="HeaderHeading">{props.heading}</div>
          <div></div>
        </div>
    )

}

export default BackHeader;