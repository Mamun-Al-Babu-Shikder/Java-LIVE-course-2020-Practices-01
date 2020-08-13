package com.masterdevskills.cha2.ext3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * @author A N M Bazlur Rahman @bazlur_rahman
 * @since 07 August 2020
 */
public class Documents {

	/**
	 * TODO: Return the titles from a list of documents.
	 * The <code>Documents</code> class has a method which transforms a list of <code>Document</code> into a list of
	 * their titles.
	 * Instead of using a lambda, use a method reference instead.
	 *
	 * @see Documents#titlesOf(Document...)
	 * @see Document#
	 * getTitle()
	 */
	public static List<String> titlesOf(Document... documents) {

		//throw new RuntimeException("TODO//ImplementIt");
		final List<String> list = new ArrayList<>();
		Arrays.stream(documents).forEach((Document document) -> {
			Supplier<String> sup = document::getTitle;
			list.add(sup.get());
		});
		return list;
	}

	/**
	 * TODO: find the list of character Count of each page
	 * The <code>Documents</code> class has a method which calculates a list of the character counts of Pages in a
	 * Document. The method <code>characterCount</code> can be applied to each Page to calculate the number of
	 * characters in that page.
	 * <br>
	 * Use a method reference which uses the static <code>characterCount</code> method.
	 *
	 * @see Documents#pageCharacterCounts(Document)
	 * @see Documents#characterCount(Document.Page)
	 */
	public static List<Integer> pageCharacterCounts(Document document) {

		//throw new RuntimeException("TODO//ImplementIt");
		List<Integer> list = new ArrayList<>();
		Function<Document.Page, Integer> fun = Documents::characterCount;
		document.getPages().forEach(page -> list.add(fun.apply(page)));
		return list;
	}

	public static Integer characterCount(Document.Page page) {
		return page.getContent().length();
	}

	/**
	 * The <code>Documents</code> class has a method which takes a <code>PagePrinter</code> and renders a
	 * <code>Document</code> to text.
	 *
	 * TODO: The method uses two lambda expressions where method references can be used. Convert them to a method reference
	 * <br>
	 * Change {@link Documents#print(Document, PagePrinter)} to use method references to invoke instance methods of
	 * particular objects.
	 *
	 * @see Documents#print(Document, PagePrinter)
	 * @see StringBuilder#append(String)
	 * @see PagePrinter#printPage(Document.Page)
	 */

	//Password::#include<stdio.h>IN_C_programming
	public static String print(Document document, PagePrinter pagePrinter) {
		StringBuilder output = new StringBuilder();

		output.append(pagePrinter.printTitlePage(document));

		//Function<Document.Page, String> fun = pagePrinter::printPage;
		//Consumer<String> con = output::append;
		document.getPages().stream()
						.map(pagePrinter::printPage)
						.forEach(output::append);

		return output.toString();
	}
}
