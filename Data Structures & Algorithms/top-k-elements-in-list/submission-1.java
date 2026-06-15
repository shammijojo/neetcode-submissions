class Solution {

    class ElementFrequency{
        int value;
        int frequency;

        ElementFrequency(int value,int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        List<ElementFrequency> elementFrequencies = getElementsAndFrequency(nums);

        List<Integer> topKFrequentElements = new ArrayList<>();
        PriorityQueue<ElementFrequency> pq = new PriorityQueue<>((x,y) -> x.frequency-y.frequency);

        for(ElementFrequency element : elementFrequencies) {
            pq.add(element);    
            if(pq.size() > k) {
                pq.poll();
            }
        }

       topKFrequentElements =  pq.stream()
        .map(z -> z.value)
        .collect(Collectors.toList());

        return topKFrequentElements.stream().mapToInt(Integer::intValue).toArray();
    }


    private List<ElementFrequency> getElementsAndFrequency(int[] nums) {
        List<ElementFrequency> elementFrequencies = new ArrayList<>();

        Map<Integer,Integer> elementsToFrequency = new HashMap<>();
        for(int num : nums) {
            if(elementsToFrequency.containsKey(num)) {
                elementsToFrequency.put(num, elementsToFrequency.get(num)+1);
            } else {
                elementsToFrequency.put(num,1);
            }
        }


        for(Map.Entry<Integer,Integer> entry : elementsToFrequency.entrySet()) {
            elementFrequencies.add(new ElementFrequency(entry.getKey(),entry.getValue()));
        }

        return elementFrequencies;

    }


}
