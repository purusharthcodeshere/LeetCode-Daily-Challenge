class Solution {
    public long dividePlayers(int[] skill) {
    int skillFreq[] = new int[1001];
  
    int total = 0;
    for(int x : skill)
    {
      skillFreq[x]++;
      total +=x;
    } 
   if(total%(skill.length/2)!=0)
   return -1;

   int perTeamSkill = total/(skill.length/2);
     long chemistry = 0;

   for(int s : skill) {
     int partnerVal = perTeamSkill - s; 
     if(skillFreq[partnerVal]==0)
     return -1;
     chemistry += (long)s*(long)partnerVal;
     skillFreq[partnerVal]--;
   }
     return chemistry/2;
    }
}