public class Codec {
   HashMap<String,String>hm;
    public Codec(){
        hm=new HashMap<>();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb=new StringBuilder();
        Random r=new Random();
        char ch=(char)(r.nextInt(100));
        sb.append(ch);
        
        while(hm.containsKey(sb.toString())){
            ch=(char)(r.nextInt(100));
            sb.append(ch);
        }
        
        hm.put(sb.toString(),longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hm.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));