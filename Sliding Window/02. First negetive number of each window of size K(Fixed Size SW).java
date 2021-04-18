public static ArrayList<Integer> firstNegetiveNumberInEveryWindow(int [] arr, int k)
    {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int i=0;
        int j=0;
        while(j<arr.length)
        {
            if(arr[j] <0)
                q.add(arr[j]);
            if(j-i+1 <k)
            {
                j++;
            }
            else if(j-i+1 == k)
            {
                if(q.size() ==0)
                    res.add(0);
                else
                {
                    res.add(q.peek());
                    if(q.peek() == arr[i])
                        q.poll();
                }
                j++;
                i++;

            }
        }
        return res;

    }
