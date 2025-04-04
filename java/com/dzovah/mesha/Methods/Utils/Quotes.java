package com.dzovah.mesha.Methods.Utils;

/**
 * Utility class that provides motivational and educational financial quotes.
 * <p>
 * This class manages a collection of inspirational quotes related to finance,
 * investing, wealth, and money management. It selects quotes based on the current
 * date, ensuring that users see a different quote each day without repetition
 * within the quote collection cycle.
 * </p>
 * <p>
 * The quotes are intended to educate and motivate users of the Mesha financial
 * application, encouraging good financial habits and providing wisdom from
 * successful investors and financial experts.
 * </p>
 *
 * @author Electra Magus
 * @version 1.0
 */
public class Quotes {
    /** Array containing all available financial quotes */
    private final String[] quotes;

    /**
     * Constructs a new Quotes instance with a predefined collection of financial quotes.
     * <p>
     * Initializes the quotes array with a comprehensive collection of financial wisdom
     * from various sources, including famous investors, entrepreneurs, and financial experts.
     * </p>
     */
    public Quotes() {
        quotes = new String[]{
            "An investment in knowledge pays the best interest.",
            "The more you learn, the more you earn.",
            "An investment in knowledge pays the best interest.",
            "The best way to predict the future is to create it.",
            "An investment in knowledge pays the best interest.",
            "The stock market is filled with individuals who know the price of everything, but the value of nothing.",
            "The individual investor should act consistently as an investor and not as a speculator.",
            "Financial freedom is available to those who learn about it and work for it.",
            "Investing should be more like watching paint dry or watching grass grow. If you want excitement, take $800 and go to Las Vegas.",
            "The four most dangerous words in investing are: 'this time it's different.'",
            "The secret to investing is to figure out the value of something – and then pay a lot less.",
            "Don't look for the needle in the haystack. Just buy the haystack!",
            "The goal of a successful trader is to make the best trades. Money is secondary.",
            "The investor's chief problem – and even his worst enemy – is likely to be himself.",
            "Wide diversification is only required when investors do not understand what they are doing.",
            "Know what you own, and know why you own it.",
            "In the short run, the market is a voting machine, but in the long run, it is a weighing machine.",
            "Risk comes from not knowing what you're doing.",
            "Price is what you pay. Value is what you get.",
            "It's not whether you're right or wrong that's important, but how much money you make when you're right and how much you lose when you're wrong.",
            "You get recessions, you have stock market declines. If you don't understand that's going to happen, then you're not ready, you won't do well in the markets.",
            "The function of economic forecasting is to make astrology look respectable.",
            "Money won't create success, the freedom to make it will.",
            "The stock market is designed to transfer money from the Active to the Patient.",
            "Rich people have small TVs and big libraries, and poor people have small libraries and big TVs.",
            "Wealth consists not in having great possessions, but in having few wants.",
            "The real measure of your wealth is how much you'd be worth if you lost all your money.",
            "A wise person should have money in their head, but not in their heart.",
            "Formal education will make you a living; self-education will make you a fortune.",
            "The best investment you can make is in yourself.",
            "The only way to beat the market is to make fewer mistakes than others.",
            "Beware the investment activity that produces applause; the great moves are usually greeted by yawns.",
            "Money is a terrible master but an excellent servant.",
            "Wealth is not his that has it, but his that enjoys it.",
            "Spend your money on the things money can buy. Spend your time on the things money can't buy.",
            "Financial peace isn't the acquisition of stuff. It's learning to live on less than you make, so you can give money back and have money to invest.",
            "The habit of saving is itself an education; it fosters every virtue, teaches self-denial, cultivates the sense of order, trains to forethought, and so broadens the mind.",
            "Never spend your money before you have earned it.",
            "Wealth is the ability to fully experience life.",
            "Happiness is not in the mere possession of money; it lies in the joy of achievement, in the thrill of creative effort.",
            "Do not save what is left after spending, but spend what is left after saving.",
            "To acquire money requires valor, to keep money requires prudence, and to spend money well is an art.",
            "Frugality includes all the other virtues.",
            "The best thing money can buy is financial freedom.",
            "The biggest risk of all is not taking one.",
            "The more you learn, the more you earn.",
            "Invest in yourself. Your career is the engine of your wealth.",
            "Wealth is the product of man's capacity to think.",
            "Financial freedom is freedom from fear.",
            "Your economic security does not lie in your job; it lies in your own power to produce, to think, to learn, to create, to adapt.",
            "Wealth flows from energy and ideas.",
            "The real key to making money in stocks is not to get scared out of them.",
            "Rule No. 1: Never lose money. Rule No. 2: Never forget Rule No. 1.",
            "Behind every stock is a company. Find out what it's doing.",
            "The goal is not to be perfect by the end, but to be better today.",
            "You must gain control over your money or the lack of it will forever control you.",
            "Riches do not consist in the possession of treasures, but in the use made of them.",
            "Time is more valuable than money. You can get more money, but you cannot get more time.",
            "The quickest way to double your money is to fold it in half and put it back in your pocket.",
            "Too many people spend money they haven't earned, to buy things they don't want, to impress people they don't like.",
            "Money is only a tool. It will take you wherever you wish, but it will not replace you as the driver.",
            "The art is not in making money, but in keeping it.",
            "Rich people think long-term. Poor people think short-term.",
            "Money is a terrible master but an excellent servant.",
            "Wealth is not his that has it, but his that enjoys it.",
            "Do not be fooled by the calendar. There are only as many days in the year as you make use of.",
            "The greatest wealth is to live content with little.",
            "Money grows on the tree of persistence.",
            "To get rich, you have to be making money while you're asleep.",
            "Don't tell me what you value, show me your budget, and I'll tell you what you value.",
            "Beware of small expenses; a small leak will sink a great ship.",
            "Rich people are committed to being rich. Poor people want to be rich.",
            "You can be young without money, but you can't be old without it.",
            "Financial fitness is not pipe dreams or wishful thinking. It is a reality if you are willing to pursue it and embrace it.",
            "The only place where success comes before work is in the dictionary.",
            "You must spend money to make money.",
            "The man who does not value himself, cannot value anything or anyone.",
            "Financial security and independence are like a three-legged stool resting on savings, insurance and investments.",
            "Money is like manure. You have to spread it around or it smells.",
            "The rich invest in time, the poor invest in money.",
            "It's not the employer who pays the wages. Employers only handle the money. It's the customer who pays the wages.",
            "It's not how much money you make, but how much money you keep, how hard it works for you, and how many generations you keep it for.",
            "The rich see assets as a source of income. The poor see assets as a source of expenses.",
            "The biggest risk is not taking any risk.",
            "Financial freedom is freedom from fear.",
            "An investment in knowledge pays the best interest.",
            "Money often costs too much.",
            "Money is the opposite of the weather. Nobody talks about it, but everybody does something about it.",
            "The rich invest in assets, while the poor invest in liabilities.",
            "Money won't create success, the freedom to make it will.",
            "Wealth is not about having a lot of money; it's about having a lot of options.",
            "The rich get richer because the poor think every opportunity is a scam.",
            "The most successful people see adversity not as a stumbling block, but as a stepping stone to greatness.",
            "Money is a tool for freedom. It allows you to take control of your life and pursue your passions.",
            "Financial freedom is the ability to live the lifestyle you desire without having to work or rely on anyone else for money.",
            // Add more quotes here
        };
    }

    /**
     * Calculates the index of today's quote based on the current date.
     * <p>
     * This method uses the current timestamp (in milliseconds) divided by the number
     * of milliseconds in a day to generate a date-based index. This ensures that
     * the same quote is shown throughout a given day, but a different quote is
     * presented on different days.
     * </p>
     *
     * @return The index of today's quote in the quotes array
     */
    private int getQuoteIndex() {
        return (int) (System.currentTimeMillis() / 86400000) % quotes.length;
    }

    /**
     * Returns the quote of the day.
     * <p>
     * This method selects and returns a quote based on the current date. The same
     * quote will be returned for the entire day, and it will change at midnight.
     * The selection cycles through the entire collection of quotes before repeating.
     * </p>
     *
     * @return The quote of the day as a String
     */
    public String presentQuote() {
        int index = getQuoteIndex();
        return quotes[index];
    }
}