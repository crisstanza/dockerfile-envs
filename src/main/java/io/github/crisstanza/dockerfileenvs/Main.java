package io.github.crisstanza.dockerfileenvs;

public final class Main
{
	public static final void main(final String[] args) throws Exception
	{
		final Library library = new Library();
		System.out.println("Success? " + library.start());
	}

}
