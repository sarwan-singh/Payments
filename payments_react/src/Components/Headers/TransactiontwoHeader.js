import { useHistory } from 'react-router-dom';
import back from '../../Icons/back.png';
import '../HeadersCSS/BackHeader.css'

function TranscationtwoHeader(props){
    var history = useHistory();
    return(
        <div className="BackHeader">
          <img src={back} className="back" onClick={()=>props.setValidatedFirstPage(false)}/>
          <div className="HeaderHeading">{props.heading}</div>
          <div></div>
        </div>
    )

}

export default TranscationtwoHeader;