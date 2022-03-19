package com.example.practicekotlin10

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuotesPagerAdapter(
    private val quotes: List<Quote>,
    private val isNameRevealed: Boolean
) : RecyclerView.Adapter<QuotesPagerAdapter.QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        QuoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_quote, parent, false)
        )

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val actualPosition = position % quotes.size
        holder.bind(quotes[actualPosition], isNameRevealed)
    }

    override fun getItemCount() = Int.MAX_VALUE


    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewQuote: TextView = itemView.findViewById(R.id.textViewQuote)
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)

        @SuppressLint("SetTextI18n")
        fun bind(quote: Quote, isNameRevealed: Boolean) {
            textViewQuote.text = "\"${quote.quote}\""

            if(isNameRevealed) {
                textViewName.text = "- ${quote.name}"
                textViewName.visibility = View.VISIBLE
            } else {
                textViewName.visibility = View.GONE
            }

        }
    }

}