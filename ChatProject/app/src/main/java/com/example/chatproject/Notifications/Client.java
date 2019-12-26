package com.example.chatproject.Notifications;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//class SenderDeserializer implements JsonDeserializer<Sender> {
//    public Sender deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
//            throws JsonParseException {
//        Log.d("sending", json.getAsString());
//        Log.d("sending", typeOfT.toString());
//        Log.d("sending", context.toString());
//        Sender sender = new Sender(new Data(), "me");
//        // Do the Processing here
//        return sender;
//    }
//}

//class CustomInterceptor implements Interceptor {
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        /*
//        chain.request() returns original request that you can work with(modify, rewrite)
//        */
//        Request request = chain.request();
//        // Here you can rewrite the request
//        /*
//        chain.proceed(request) is the call which will initiate the HTTP work. This call invokes the
//        request and returns the response as per the request.
//        */
//        Response response = chain.proceed(request);
//        Log.d("sending", response.headers().toString());
//        String rawJson = response.body().string();
//
//        Log.d("sending", rawJson);
//        try {
//            Object object = new JSONTokener(rawJson).nextValue();
//            Log.d("sending", object.getClass().toString());
//            String jsonLog;
//            if (object instanceof JsonObject) {
//                jsonLog = ((JSONObject) object).toString(4);
//            } else if (object instanceof JSONArray) {
//                jsonLog = ((JSONArray) object).toString(4);
//            } else {
//                jsonLog = object.toString();
//            }
//            Log.d("sending", jsonLog);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        //Here you can rewrite/modify the response
//        return response;
//    }
//}


public class Client {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String url) {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
//                    .registerTypeAdapter(Sender.class, new SenderDeserializer())
                    .setLenient()
                    .create();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
//                   .addInterceptor(new CustomInterceptor())
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
