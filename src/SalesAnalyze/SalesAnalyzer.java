package SalesAnalyze;

public class SalesAnalyzer 
{
	private double sales[];  // sales array which is store the data in day format
	private int daysInMonth;  // days is in integer

	public SalesAnalyzer(int daysInMonth)
	{
		this.sales = new double[daysInMonth];
		this.daysInMonth = daysInMonth;
	}
	public void addSale(double saleAmount , int day)
	{
		try 
		{
			if (day < 1 || day > daysInMonth ) 
			{
				System.out.println("Error : Invalid day Enter please provide day between 1 to "+daysInMonth);
				return;
			}
			sales[day-1] = sales[day-1] +saleAmount;
		} 
		catch (Exception e) 
		{
			System.out.println("Exception in adding sale..! kindly check");
		}
	}
	public double calculateTotalSales()
	{
 		if(sales.length <= 0)
		{
			System.out.println("There is no sale Yet Please first do a sale and then try");
		}
		double totalSales= 0;
		for(double sale :sales)
		{
			totalSales = totalSales+ sale;
		}
		return totalSales;
	}
	public double calculateAverageDailySales()
	{
		return calculateTotalSales()/daysInMonth;
	}
	public double findBestSalesDay()
	{
		int bestSaleday = 0;
		double maxSales = Integer.MIN_VALUE; // sales[0];
		
		for (int i = 0; i < sales.length; i++)
		{
			if(sales[i]>maxSales)
			{
				maxSales = sales[i];
				bestSaleday = i+1;
			}
		}	
		return bestSaleday;
	}
	public double findWorstSalesDay()
	{
		int worstSaleDay =0;
		double minSales = Integer.MAX_VALUE;
		
		for (int i = 0; i < sales.length; i++) 
		{
			if(sales[i]<minSales)
			{
				minSales = sales[i];
				worstSaleDay = i+1;
			}
		}
		return worstSaleDay;
	}
	public void displaySalesReport() 
	{
        System.out.println("Total Sales: $" + calculateTotalSales());
        System.out.println("Average Daily Sales: $" + calculateAverageDailySales());
        System.out.println("Best Sales Day: Day " + findBestSalesDay() + " with $" + sales[(int) (findBestSalesDay() - 1)]);
        System.out.println("Worst Sales Day: Day " + findWorstSalesDay() + " with $" + sales[(int) (findWorstSalesDay() - 1)]);
    }
	public static void main(String[] args)
	{
		int daysInMonth = 30; //  here 30 days in month
		SalesAnalyzer salesAnalyzer = new SalesAnalyzer(daysInMonth);// 
//		salesAnalyzer.addSale(200, 1);
//		salesAnalyzer.addSale(232, 2);
//		salesAnalyzer.addSale(400, 3);
//		salesAnalyzer.addSale(500, 4);
		for (int day = 1; day <= daysInMonth; day++)
		{			
			double salesAmount = Math.random() * 1000;
			salesAnalyzer.addSale(salesAmount, day);
		}
		salesAnalyzer.displaySalesReport();
	}
}