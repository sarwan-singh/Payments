import { useHistory } from 'react-router-dom';
import logout from '../../Icons/logout.png';
import '../HeadersCSS/LogoutHeader.css'

function LogoutHeader(props){
    var history = useHistory();

    const signout = () =>{
      localStorage.removeItem("jwt");
      history.replace("/home")
    }

    return(
        <div className="LogoutHeader">
          <div></div>
          <div className="HeaderHeading">{props.heading}</div>
          <img src={logout} className="logout" onClick={()=>signout()}/>
        </div>
    )

}

export default LogoutHeader;