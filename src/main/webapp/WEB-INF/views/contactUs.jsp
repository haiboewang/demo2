<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#zipcode").blur(function() {
		var zip = $("#zipcode").val();
		if(zip.length != 5) {
			alert("Zip code must be 5 digits.")
		}
		$.getJSON("http://localhost:9080/web/contactUs/cityStateLookup/" + zip, function(cityStateZipDto) {
			var temp;
			var numberOfCities = cityStateZipDto.cityList.length;
			if(numberOfCities == 1) {
				temp = "<input id='city' name='customer.city' value='" + cityStateZipDto.cityList[0] + "'>";
			} else {
				temp = "<select id='city' name='customer.city'>";
				for(var i=0; i<numberOfCities; i++) {
					temp += "<option value='" + cityStateZipDto.cityList[i] + "'>" + cityStateZipDto.cityList[i] + "</option>";
				}
				temp += "</select>";
			}
			//city
			$("#cityContainer").html(temp);
			//state
			temp = "<select id='state' name='customer.state'>" +
				"<option value='" + cityStateZipDto.state.stateCode + "'>" + cityStateZipDto.state.name + "</option>" +
				"</select>";
			$("#stateContainer").html(temp);
		});
	});
}); 
</script>
    <div class="container-left">
      <div>
        <div class="insidebanner"></div>
      </div>
      <div class="clear"></div>
      <div class="workarea">
        <div>
          <div>
            <h2>Contact!</h2>
          </div>
          <div class="service-content">
            <div style="margin-bottom:10px;">
              <div> <strong> Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin sed odio et ante adipiscing lobortis. Quisque eleifend, arcu a dictum varius, risus neque venenatis arcu, a semper massa mi eget ipsum. </strong><br />
                <br />
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin sed odio et ante adipiscing lobortis. Quisque eleifend, arcu a dictum varius, risus neque venenatis arcu, a semper massa mi eget ipsum. </div>
              <div> <br />
                <h6>Contact Form:</h6>
                <form:form id="contactUs" method="post" action="contactUs" commandName="contactUs" >
                  <table width="97%">
                    <tr>                      
                      <td align="left" valign="top" class="body" id="firstName"><strong>First Name:</strong></td>
                      <td align="left" valign="top"><form:input path="customer.firstName" size="40" /></td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body" id="firstName"><strong>Last Name:</strong></td>
                      <td align="left" valign="top"><form:input path="customer.lastName" size="40" /></td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body" id="address_1"><strong>Address 1: </strong></td>
                      <td align="left" valign="top"><form:input path="customer.address1" size="40" /></td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body" id="address_2"><strong>Address 2: </strong></td>
                      <td align="left" valign="top"><form:input path="customer.address2" size="40" /></td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body"><strong>Zip Code (We'll prefill city and state for you): </strong></td>
                      <td align="left" valign="top"><form:input id="zipcode" path="customer.zipcode" size="10"/></td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body"><strong>City</strong></td>
                      <td align="left" valign="top">
                      	<span id="cityContainer">
                      		<form:input id="city" path="customer.city" size="40" />
                      	</span>
                    </td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body"><strong>State: </strong></td>
                      <td align="left" valign="top">
                      	<span id="stateContainer">
                      		<form:input id="state" path="customer.state" size="40" />
                      	</span>
                      </td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body" id="phone"><strong>Phone: </strong></td>
                      <td align="left" valign="top"><form:input path="customer.phone" size="40" /></td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body" id="email"><strong>Email: </strong></td>
                      <td align="left" valign="top"><form:input path="customer.email" size="40" /></td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body" id="category"><strong>Category: </strong></td>
                      <td align="left" valign="top"><form:select path="category" items="${categories}" /></td>
                    </tr>
                    <tr>
                      <td align="left" valign="top" class="body"><strong> Questions / Comments: </strong></td>
                      <td align="left" valign="top"><form:textarea id="comment" path="comment" cols="32" rows="6" /></td>
                    </tr>
                    <tr>
                      <td></td>
                      <td><input type="submit" name="submit" class="button" value="Send Now" /></td>
                    </tr>
                  </table>
                
				</form:form>
              </div>
              <div> <br />
                <h6>Contact Information: </h6>
                <img src="resources/images/photo-contact.jpg" alt="" width="196" height="130" class="project-img" />
                <p>100 Lorem Ipsum Dolor Sit<br />
                  88-99 Sit Amet, Lorem<br />
                  USA</p>
                <p> <span><img src="resources/images/ico-phone.png" alt="" width="20" height="16" hspace="2"  /> Phone:</span> (888) 123 456 789<br />
                  <span><img src="resources/images/ico-fax.png" alt="" width="20" height="16" hspace="2"  /> Fax:</span> (888) 987 654 321<br />
                  <span><img src="resources/images/ico-website.png" alt="" width="20" height="16" hspace="2"  /> Website:</span> <a href="http://all-free-download.com/free-website-templates/">www.mycompany.com</a><br />
                  <span><img src="resources/images/ico-email.png" alt="" width="20" height="16" hspace="2"  /> Email:</span> <a href="http://all-free-download.com/free-website-templates/">info@mycompany.com</a><br />
                  <span><img src="resources/images/ico-twitter.png" alt="" width="20" height="16" hspace="3"  /> <a href="http://all-free-download.com/free-website-templates/">Follow</a> on Twitter</span><br />
                </p>
              </div>
            </div>
          </div>
        </div>
        <div class="clear"></div>
        <div> </div>
      </div>
    </div>
    <div class="container-right">
      <div>
        <div class="welcomezone">
          <div class="welcomebottom">
            <div class="welcomeworkarea">
              <h1>Welcome</h1>
              <div> <strong>Proin eu velit. Donec blandit</strong>, orci id dapibus pretium, metus ante pulvinar nunc, ac vestibulum nisi metus nec nisl. Sed non libero ac dolor eleifend varius. Maecenas mollis, metus eu porta sodales, metus metus sodales augue, id iaculis risus velit eu lectus. Vestibulum in neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.<br />
                <br />
                <strong>Lorem ipsum dolor sit amet</strong>, consectetuer adipiscing elit. Duis cursus tortor. Nunc consectetuer diam ac odio. Pellentesque vel mauris sit amet urna malesuada ornare. Curabitur venenatis est eget arcu. Donec vestibulum. Proin rutrum. Morbi commodo fringilla orci. Ut vel tortor. </div>
            </div>
          </div>
        </div>
      </div>
      <div class="clear"></div>
      <div class="workarea">
        <div>
          <div>
            <h2>What's <span class="greenheading">New</span></h2>
          </div>
          <div class="newszone">
            <div>
              <div class="blackfont12" style="margin-top:0px;">Aliquam non | <span class="bluefontlight">22.05.2009</span></div>
              <div>In nec tellus congue libero ultricies molestie. Duis et diam. Suspendisse interdum velit eget pede. Duis facilisis dignissim urna. </div>
            </div>
            <div>
              <div class="blackfont12">Sollicitudin velit | <span class="bluefontlight">24.05.2009</span></div>
              <div>Vestibulum convallis metus eget orci posuere bibendum. Quisque sit amet augue.Nam magna. Pellentesque vitae velit at dui semper sodales. Curabitur accumsan libero.</div>
            </div>
            <div>
              <div class="blackfont12">Sollicitudin velit | <span class="bluefontlight">27.05.2009</span></div>
              <div>In nec tellus congue libero ultricies molestie. Duis et diam. Suspendisse interdum velit eget pede. Duis facilisis dignissim urna. Proin eu velit. Donec blandit, orci id dapibus pretium, metus ante pulvinar nunc, ac vestibulum nisi metus nec nisl. </div>
            </div>
          </div>
          <div class="more"><img src="../images/morenews.jpg" alt="" border="0" /></a></div>
          <div class="contact">
            <div class="contactheading">Contact</div>
            <span class="whitebold">Architectural Company</span><br />
            69, Nunc a quam <br />
            Morbi diam city<br />
            PIN - 4567890</div>
        </div>
      </div>
    </div>
    <div class="clear"></div>