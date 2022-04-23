<style>

    #marker {
        background-image: url('static/img/favicon.ico');
        background-size: cover;
        width: 50px;
        height: 50px;
        border-radius: 50%;
        cursor: pointer;
    }

    .mapboxgl-popup {
        max-width: 200px;
    }

</style>

<footer class="page-footer font-small blue-grey lighten-5" style="margin-top: 5%;">

    <div style="background-color: #c7e7de;">
        <div class="container">
            <div class="row py-4 d-flex align-items-center">

                <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
                    <h6 class="mb-0">Get connected with us on social networks!</h6>
                </div>
                <div class="col-md-6 col-lg-7 text-center text-md-right">

                    <a class="fb-ic" href="https://uk-ua.facebook.com/" style="color: #223628">
                        <i class="fab fa-facebook-f white-text mr-4"> </i>
                    </a>
                    <a class="tw-ic" href="https://twitter.com/?lang=en" style="color: #223628">
                        <i class="fab fa-twitter white-text mr-4"> </i>
                    </a>
                    <a class="gplus-ic" href="https://mail.google.com" style="color: #223628">
                        <i class="fab fa-google-plus-g white-text mr-4"> </i>
                    </a>
                    <a class="li-ic" href="https://www.linkedin.com/" style="color: #223628">
                        <i class="fab fa-linkedin-in white-text mr-4"> </i>
                    </a>
                    <a class="ins-ic" href="http://instagram.com" style="color: #223628">
                        <i class="fab fa-instagram white-text"> </i>
                    </a>

                </div>

            </div>

        </div>
    </div>
    <div class="container text-center text-md-left mt-5">

        <div class="row mt-3 dark-grey-text">

            <!--<div class="col-md-3 col-lg-4 col-xl-3 mb-4" style="max-width: 310px; margin-left: auto; margin-right: auto;">
                <div id='map' style='width: 300px; height: 300px;'></div>
                <script>
                mapboxgl.accessToken = 'pk.eyJ1IjoieXVsaWF0b2thbiIsImEiOiJjazB6OWk5OWUwMGsxM2RxZ251cGdwbjB2In0.MaIAWWkVHZ6YR07FbTbvfA';

                var monument = [30.522218, 50.448900];
                var map = new mapboxgl.Map({
                    container: 'map',
                    style: 'mapbox://styles/mapbox/light-v10',
                    center: monument,
                    zoom: 15
                });

                // create the popup
                var popup = new mapboxgl.Popup({ offset: 25 })
                    .setText('Welcome! 36 Khreschatyk Str 10:00-8:00 p.m.');

                // create DOM element for the marker
                var el = document.createElement('div');
                el.id = 'marker';

                // create the marker
                new mapboxgl.Marker(el)
                    .setLngLat(monument)
                    .setPopup(popup) // sets a popup on this marker
                    .addTo(map);

            </script>
            </div>-->
            <div class="col-md-3 col-lg-4 col-xl-3 mb-4">
                <h6 class="text-uppercase font-weight-bold">Contact Us</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">

                <form id="contact_form" onsubmit="return false">
                    <div class="form-group row">
                        <label for="inputEmail" class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail" placeholder="Your name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputName" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="inputName" placeholder="Your email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <textarea class="form-control" id="inputMsg" placeholder="Your message"></textarea>
                        </div>
                    </div>
                    <div class="form-group row" style="float: right">
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary"
                                    style="background: #5CC8AA; border-color: #5CC8AA" onclick="send()">Send
                            </button>
                        </div>
                    </div>
                </form>
            </div>

            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

                <h6 class="text-uppercase font-weight-bold">Products</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a style="color: #232323;" href="/products/dresses">Dresses</a>
                </p>
                <p>
                    <a style="color: #232323;" href="/products/overalls">Overalls</a>
                </p>
                <p>
                    <a style="color: #232323;" href="/products/t-shirts&tops">T-shirts&Tops</a>
                </p>
                <p>
                    <a style="color: #232323;" href="/products/denim">Denim</a>
                </p>
                <p>
                    <a style="color: #232323;" href="/products/skirts">Skirts</a>
                </p>
                <p>
                    <a style="color: #232323;" href="/products/pants">Pants</a>
                </p>

            </div>
            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

                <h6 class="text-uppercase font-weight-bold">Useful links</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a style="color: #232323;" href="/cart">Your Cart</a>
                </p>
                <p>
                    <a style="color: #232323;" href="sign_in">Sign In</a>
                </p>
                <p>
                    <a style="color: #232323;" href="/campaign">Campaign</a>
                </p>
                <p>
                    <a style="color: #232323;" href="/about_us">About Us</a>
                </p>

            </div>
            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

                <h6 class="text-uppercase font-weight-bold">Contact</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-home mr-3"></i> Ukraine, Kiev</p>
                <p>
                    <i class="fas fa-envelope mr-3"></i> tokan.clothes@gmail.com</p>
                <p>
                    <i class="fas fa-phone mr-3"></i> +380669216422</p>

            </div>
        </div>
    </div>
    <div class="footer-copyright text-center text-black-50 py-3"> &copy; 2019 Tokan Yulia
    </div>
</footer>
<script>
    function send() {
        $('#inputName').val('');
        $('#inputEmail').val('');
        $('#inputMsg').val('');
    }
</script>
