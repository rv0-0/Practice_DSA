public static ArrayList<Integer> maxOfSubarray(int []arr, int k)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        int i=0;
        int j=0;
        while(j<arr.length)
        {
            while (q.size() >0 && arr[j]>q.peek())
            {
                q.poll();
            }
            q.add(arr[j]);
            System.out.println(q);

            if(j-i+1 <k)
                j++;
            else if(j-i+1 == k)
            {
                res.add(q.peek());
                if(arr[i] == q.peek())
                    q.poll();
                i++;
                j++;
            }
        }
        return res;
    }
