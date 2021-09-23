import digitalBanking from "../../Icons/digitalBanking.png"
import privacygreen from "../../Icons/privacygreen.jpg"
import onlinebanking from "../../Icons/onlinebanking.png"
import "../CarouselCSS/Carousel.css"
const Carouseli = () => {
  
  return (
    <div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active" data-interval="1000">
      <img src={onlinebanking} className="slides" />
    </div>
    <div class="carousel-item" data-interval="1000">
      <img src={digitalBanking} className="slides"/>
    </div>
    <div class="carousel-item" data-interval="1000">
      <img src={privacygreen} className="slides" />
    </div>
  </div>
  <a class="carousel-control-prev"  href="#carouselExampleFade" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
  )
}
export default Carouseli;