package io.github.crisstanza.dockerfileenvs;

public final class Main
{
	private Library library = new Library();

	public static final void main(final String[] args) throws Exception
	{
		new Main().start();
	}

	private final void start() throws Exception
	{
		System.out.println("Success? " + this.library.start());
	}

}
