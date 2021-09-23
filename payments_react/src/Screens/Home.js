import {useHistory} from 'react-router-dom'
import homebank from "../Icons/homebank.JPG"
import '../Css/Home.css'
import Carouseli from '../Components/Carousel/Carousel';
import Creators from '../Components/Creators/Creators';
import Aboutus from '../Components/Aboutus/Aboutus';
function Home() {
  const history = useHistory();

  const sendUser = (address) =>{
    history.push("/"+address)
  }

  return (
    <div>
    <div className="Home">
      <div ><img className="HomeBank" src={homebank}></img></div>
         <div className="Welcome">Welcome to <b>ABKB</b> Bank</div>
         <div><Carouseli/></div>
      <button className="buttonHome" onClick={()=>sendUser("customerLogin")}>Customer Login</button>
      <button className="buttonHome" onClick={()=>sendUser("employeeLogin")}>Employee Login</button>
    </div>
    <div><Aboutus/></div>
    <div><Creators/></div>
    </div>
    
  );
}

export default Home;
