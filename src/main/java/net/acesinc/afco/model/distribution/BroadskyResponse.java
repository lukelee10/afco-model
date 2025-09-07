package net.acesinc.afco.model.distribution;

public class BroadskyResponse {
    private Body body;
    private Headers headers;

    public BroadskyResponse() {
        this.setBody(new Body());
        this.setHeaders(new Headers());
    }

    public BroadskyResponse(String id) {
        this.setBody(new Body(id));
        this.setHeaders(new Headers());
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public class Body {
        private String id;

        public Body() {}
        ;

        public Body(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Body{" + "id='" + id + '\'' + '}';
        }
    }

    public class Headers {
        public Headers() {}
        ;
    }

    @Override
    public String toString() {
        return "BroadskyResponse{" + "body=" + body + '}';
    }
}
