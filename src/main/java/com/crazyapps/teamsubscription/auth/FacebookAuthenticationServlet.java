package com.crazyapps.teamsubscription.auth;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.crazyapps.teamsubscription.C;
import com.crazyapps.teamsubscription.dto.FBUser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class FacebookAuthenticationServlet
 */
// TODO Handle exceptions
// TODO Remove deprecated methods
public class FacebookAuthenticationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacebookAuthenticationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Youhouuuuuu");
		HttpSession httpSession = request.getSession();
		String faceCode = request.getParameter("code");
		String accessToken = getFacebookAccessToken(faceCode);
		FBUser fbUser = getFBUserFromFBToken(accessToken);
		String sessionID = httpSession.getId();
		httpSession.setAttribute(C.USER, fbUser);
		response.sendRedirect(request.getContextPath() + "/index.html");
	}

	private String getFacebookAccessToken(String faceCode) throws ClientProtocolException, IOException {
		String token = null;
		if (faceCode != null && !"".equals(faceCode)) {
			String appId = "350239068468563";
			String redirectUrl = "http://localhost:8080/auth";
			String faceAppSecret = "93d5252d2ad4b16cf7b321803f6c185c";
			String newUrl = "https://graph.facebook.com/oauth/access_token?client_id=" + appId + "&redirect_uri=" + redirectUrl + "&client_secret=" + faceAppSecret + "&code=" + faceCode;
			System.out.println(newUrl);
			HttpClient httpclient = new DefaultHttpClient();
			try {
				HttpGet httpget = new HttpGet(newUrl);
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
				String responseBody = httpclient.execute(httpget, responseHandler);
				token = StringUtils.removeEnd(StringUtils.removeStart(responseBody, "access_token="), "&expires=5180795");
			} finally {
				httpclient.getConnectionManager().shutdown();
			}
		}
		return token;
	}

	private FBUser getFBUserFromFBToken(String accessToken) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {

		if (StringUtils.isEmpty(accessToken))
			throw new IllegalStateException("accessToken cannot be null");

		String newUrl = "https://graph.facebook.com/me?access_token=" + accessToken;
		System.out.println("Get info from face --> executing request: " + newUrl);
		ObjectMapper mapper = new ObjectMapper();
		FBUser user = mapper.readValue(new URL(newUrl), FBUser.class);
		System.out.println(user);

		return user;
	}

}
