import '../Css/CustomerProfile.css';
import SessionCheck from '../Auxillary/SessionCheck';
import { useEffect, useState } from 'react';
import { getUrl } from '../Functions/Transaction';
import BackHeader from '../Components/Headers/BackHeader';
import profile from '../Icons/profile.png';

function CustomerProfile() {
  var [custDetails, setCustDetails] = useState({});
  useEffect(() => {
    var jwtStored = localStorage.getItem("jwt")
    var options = {
      method: 'GET',
      headers: { 'Content-Type': 'application/json', 'Authorization': "Bearer " + jwtStored }
    }
    fetch(getUrl() + "/customer/user", options).then(response => response.json())
      .then(result => {
        setCustDetails(result.data);
        console.log(result.data)
      })
  }, [])

  // const DisplayProperty = (props)=>{
  //   return(
  //     <div className="CustomerProfileSection">
  //       <div className="CustomerProfileKey">{props.keys}</div>
  //       <div className="CustomerProfileValue">{props.value==""?"--":props.value}</div>
  //     </div>
  //   )
  // }

  return (
    <SessionCheck>
      <div className="CustomerProfile">
        <BackHeader heading="Profile" />

        <div>
          <div >
            <div class="container contact-form ">
              <form method="post">
                <div class="container-fluid1 mt-0 ">
                  <div class="row offset-md-3">
                    <div class="card col-md-8"
                      className="card1 col-md-8" >
                      <div>
                        <div class="row mb-3 mt-3">
                          <label for="ClientId" class=" labeltext col-sm-6 col-form-label">Customer Name</label>
                          <div class="col-sm-6">
                            {custDetails.accountholdername}
                          </div>
                        </div>
                        <div class="row mb-3 mt-3">
                          <label for="ClientName" class="labeltext col-sm-6 col-form-label">
                            ID</label>
                          <div class="col-sm-6">
                            {custDetails.customerid}
                          </div>
                        </div>
                        <div class="row mb-3 mt-3">
                          <label for="TransactionLimit" class="labeltext col-sm-6 col-form-label">City</label>
                          <div class="col-sm-6">
                            {custDetails.customercity}
                          </div>
                        </div>
                        <div class="row mb-3 mt-3">
                          <label for="Balance" class="labeltext col-sm-6 col-form-label">Address</label>
                          <div class="col-sm-6">
                            {custDetails.customeraddress}
                          </div>
                        </div> <div class="row mb-3 mt-3">
                          <label for="Balance" class="labeltext col-sm-6 col-form-label">Balance</label>
                          <div class="col-sm-6">
                            {custDetails.clearbalance}
                          </div>
                        </div>
                        <div class="row mb-3 mt-3">
                          <label for="Balance" class="labeltext col-sm-6 col-form-label">Over-Draft</label>
                          <div class="col-sm-6">
                            {custDetails.overdraftflag ? "Applicable" : "Not Applicable"}
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>

      </div>
    </SessionCheck>
  );
}

export default CustomerProfile;
