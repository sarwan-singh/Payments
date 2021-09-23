import "../CreatorsCSS/Creators.css"
import homebank from "../../Icons/homebank.JPG"
import sarwan from "../../Icons/sarwan.png"
import prathyuusha from "../../Icons/prathyuusha.png"
import perin from "../../Icons/perin.png"
import aamir from "../../Icons/aamir.png"
import anand from "../../Icons/anand.png"
import nymish from "../../Icons/nymish.png"

const Creators = () => {
  return (
    <div className="background">
        <hr/>
        <div class="headingfounder"><h2 >Our Founders</h2></div>
        <hr />
        <div class="card-group">
          <div class="card">
            <h5 class="card-title" style={{ color: "green" }}>Sarwan Singh</h5>
            <p class="card-text">Senior Officer</p>
            <div class="card-body">
              <img class="card-img-top" src={sarwan} />
            </div>
            <div class="card-footer">
              <small class="text-muted">
                <a href="tel:+917382979605" class="fa fa-phone"></a>
                <a href="https://sarwan-singh.github.io/" class="fa fa-google"></a>
                <a href="https://www.linkedin.com/in/sarwan-singh-390177162" class="fa fa-linkedin"></a>
                <a href="#" class="fa fa-instagram"></a>
              </small>
            </div>
          </div>
          <div class="card">
            <h5 class="card-title" style={{ color: "green" }}>Prathyuusha</h5>
            <p class="card-text">Senior Officer</p>
            <div class="card-body">
              <img class="card-img-top" src={prathyuusha} />
            </div>
            <div class="card-footer">
              <small class="text-muted">
                <a href="tel:+917093626116" class="fa fa-phone"></a>
                <a href="#" class="fa fa-google"></a>
                <a href="https://www.linkedin.com/in/prathyuusha-cholleti-3759751a0" class="fa fa-linkedin"></a>
                <a href="#" class="fa fa-instagram"></a>
              </small>
            </div>
          </div>
          <div class="card">
            <h5 class="card-title" style={{ color: "green" }}>Perin Devi Behara</h5>
            <p class="card-text">Senior Officer</p>
            <div class="card-body">
              <img class="card-img-top" src={perin} />
            </div>
            <div class="card-footer">
              <small class="text-muted">
                <a href="tel:+917075217121" class="fa fa-phone"></a>
                <a href="#" class="fa fa-google"></a>
                <a href="https://www.linkedin.com/in/perin-devi-768584153" class="fa fa-linkedin"></a>
                <a href="#" class="fa fa-instagram"></a>
              </small>
            </div>
          </div>
        </div>
        <div class="card-group">
          <div class="card">
            <h5 class="card-title" style={{ color: "green" }}>Aamir Iqbal</h5>
            <p class="card-text">Senior Officer</p>
            <div class="card-body">
              <img class="card-img-top" src={aamir} />
            </div>
            <div class="card-footer">
              <small class="text-muted">
                <a href="tel:+917782837866" class="fa fa-phone"></a>
                <a href="#" class="fa fa-google"></a>
                <a href="https://www.linkedin.com/in/aamiriqbal-ai" class="fa fa-linkedin"></a>
                <a href="#" class="fa fa-instagram"></a>
              </small>
            </div>
          </div>
          <div class="card">
            <h5 class="card-title" style={{ color: "green" }}>Nymish</h5>
            <p class="card-text">Senior Officer</p>
            <div class="card-body">
              <img class="card-img-top" src={nymish} />
            </div>
            <div class="card-footer">
              <small class="text-muted">
                <a href="tel:+917013359978" class="fa fa-phone"></a>
                <a href="#" class="fa fa-google"></a>
                <a href="https://www.linkedin.com/in/nymish-chintanippu" class="fa fa-linkedin"></a>
                <a href="#" class="fa fa-instagram"></a></small>
            </div>
          </div>
          <div class="card">
            <h5 class="card-title" style={{ color: "green" }}>Anand Arun Kulkarni</h5>
            <p class="card-text">Senior Officer</p>
            <div class="card-body">
              <img class="card-img-top" src={anand} />
            </div>
            <div class="card-footer">
              <small class="text-muted">
                <a href="tel:+918446009593" class="fa fa-phone"></a>
                <a href="#" class="fa fa-google"></a>
                <a href="https://www.linkedin.com/in/anand-kulkarni-a21484169" class="fa fa-linkedin"></a>
                <a href="#" class="fa fa-instagram"></a>
              </small>
            </div>
          </div>
        </div>
      </div>
    
  )
}
export default Creators;
