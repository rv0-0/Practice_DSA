/*
* 4
* chennai bangalore
* bombay delhi
* goa chennai
* delhi goa
* 
* bombay->delhi->goa->chennai->bangalore
*/

public static String itineryroute(HashMap<String, String >map)
    {
        HashMap<String, Boolean> m = new HashMap<>();
        String path="";

        for(String from : map.keySet())
        {
            String dest = map.get(from);
            if(m.containsKey(from) == false)
                m.put(from,true);
            m.put(dest,false);
        }
        String startPoint="";
        for(String place :m.keySet())
        {
            if(m.get(place) == true) {
                startPoint = place;
                break;
            }
        }
        path = path+startPoint+"->";

        while(map.containsKey(startPoint))
        {
            startPoint = map.get(startPoint);
            path += startPoint+"->";
        }
        return path;
    }

public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String >map = new HashMap<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String from = sc.next();
            String dest = sc.next();
            map.put(from,dest);
        }
        System.out.println(itineryroute(map));
    }
