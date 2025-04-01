package com.dzovah.mesha.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * Entity class representing a sub-account (BetaAccount) in the Mesha financial management system.
 * <p>
 * A BetaAccount is a child of an AlphaAccount and represents a specific financial account
 * such as a checking account, savings account, credit card, or investment account.
 * Each BetaAccount belongs to exactly one AlphaAccount and maintains its own balance.
 * </p>
 * <p>
 * BetaAccounts are the primary containers for transactions and represent the actual
 * financial instruments that users interact with in their daily financial activities.
 * </p>
 *
 * @author Electra Magus
 * @version 1.0
 * @see AlphaAccount
 * @see Transaction
 */
@Entity(
    tableName = "Beta_accounts",
    foreignKeys = @ForeignKey(
        entity = AlphaAccount.class,
        parentColumns = "Alpha_account_id",
        childColumns = "Alpha_account_id",
        onDelete = ForeignKey.CASCADE // Define the action when the associated AlphaAccount is deleted
    )
)
public class BetaAccount {

    /**
     * Unique identifier for the BetaAccount.
     * This ID is auto-generated by Room when a new BetaAccount is inserted into the database.
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Beta_account_id")
    private int betaAccountId;

    /**
     * Foreign key reference to the parent AlphaAccount.
     * This field establishes the relationship between a BetaAccount and its parent AlphaAccount.
     */
    @ColumnInfo(name = "Alpha_account_id")
    private int alphaAccountId;  // Foreign Key to AlphaAccount

    /**
     * The name of the BetaAccount.
     * This field is used for display and identification purposes.
     */
    @ColumnInfo(name = "Beta_account_name")
    private String betaAccountName;

    /**
     * The path to the icon image for this BetaAccount.
     * This field contains a reference to an image resource used for visual identification.
     */
    @ColumnInfo(name = "Beta_account_icon")
    private String betaAccountIcon;

    /**
     * The current balance of the BetaAccount.
     * This reflects the sum of all transactions affecting this account.
     */
    @ColumnInfo(name = "Beta_account_balance")
    private double betaAccountBalance;

    /**
     * Creates a new BetaAccount with the specified parent AlphaAccount, name, icon, and initial balance.
     *
     * @param alphaAccountId The ID of the parent AlphaAccount
     * @param betaAccountName The name of the BetaAccount
     * @param betaAccountIcon The path to the icon image (null will use a default icon)
     * @param betaAccountBalance The initial balance for the BetaAccount
     */
    public BetaAccount(int alphaAccountId, String betaAccountName, String betaAccountIcon, double betaAccountBalance) {
        this.alphaAccountId = alphaAccountId;
        this.betaAccountName = betaAccountName;
        this.betaAccountIcon = betaAccountIcon != null ? betaAccountIcon : "Assets/icons"; // Default image directory
        this.betaAccountBalance = betaAccountBalance > 0 ? betaAccountBalance : 0; // Default balance is 0
    }

    /**
     * Gets the unique identifier for this BetaAccount.
     *
     * @return The BetaAccount ID
     */
    public int getBetaAccountId() {
        return betaAccountId;
    }

    /**
     * Sets the unique identifier for this BetaAccount.
     * This is typically managed by Room and not set manually.
     *
     * @param betaAccountId The BetaAccount ID to set
     */
    public void setBetaAccountId(int betaAccountId) {
        this.betaAccountId = betaAccountId;
    }

    /**
     * Gets the ID of the parent AlphaAccount.
     *
     * @return The parent AlphaAccount ID
     */
    public int getAlphaAccountId() {
        return alphaAccountId;
    }

    /**
     * Sets the ID of the parent AlphaAccount.
     * This establishes the parent-child relationship between accounts.
     *
     * @param alphaAccountId The parent AlphaAccount ID to set
     */
    public void setAlphaAccountId(int alphaAccountId) {
        this.alphaAccountId = alphaAccountId;
    }

    /**
     * Gets the name of this BetaAccount.
     *
     * @return The BetaAccount name
     */
    public String getBetaAccountName() {
        return betaAccountName;
    }

    /**
     * Sets the name of this BetaAccount.
     *
     * @param betaAccountName The BetaAccount name to set
     */
    public void setBetaAccountName(String betaAccountName) {
        this.betaAccountName = betaAccountName;
    }

    /**
     * Gets the path to the icon image for this BetaAccount.
     *
     * @return The path to the icon image
     */
    public String getBetaAccountIcon() {
        return betaAccountIcon;
    }

    /**
     * Sets the path to the icon image for this BetaAccount.
     *
     * @param betaAccountIcon The path to the icon image to set
     */
    public void setBetaAccountIcon(String betaAccountIcon) {
        this.betaAccountIcon = betaAccountIcon;
    }

    /**
     * Gets the current balance of this BetaAccount.
     *
     * @return The current balance
     */
    public double getBetaAccountBalance() {
        return betaAccountBalance;
    }

    /**
     * Sets the balance of this BetaAccount.
     * When the balance changes, the parent AlphaAccount should be updated 
     * using {@link AlphaAccount#updateBalanceFromBetaAccounts}.
     *
     * @param betaAccountBalance The balance to set
     */
    public void setBetaAccountBalance(double betaAccountBalance) {
        this.betaAccountBalance = betaAccountBalance;
    }
}
